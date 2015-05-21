package com.sankuai.hackathon.lbs.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Description: PlanController
 * Author: liuzhao
 * Create: 2014-09-03 18:47:37
 */
public class HttpUtil {

    static final int TIMEOUT = 10 * 1000;

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static byte[] getBytes(String url) {
        return getBytes(url, "GET", null, null, null);
    }

    public static String sendGet(String url) {
        return send(url, "GET", null, null, null);
    }

    public static String sendPost(String url, String param) {
        return send(url, "POST", param, null, null);
    }

    private static byte[] getBytes(String url, String method, String param, Map<String, String> headers, InetSocketAddress addr) {
        try {
            HttpURLConnection conn = getConnection(url, method, param, headers, addr, null);
            InputStream input = getInputStream(conn);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            int count;
            byte[] buffer = new byte[4096];
            while ((count = input.read(buffer, 0, buffer.length)) > 0) {
                output.write(buffer, 0, count);
            }
            input.close();
            return output.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String send(String url, String method, String param, Map<String, String> headers, InetSocketAddress addr) {
        try {
            String result = null;
            HttpURLConnection conn = getConnection(url, method, param, headers, addr, null);
            String charset = conn.getHeaderField("Content-Type");
            charset = detectCharset(charset);
            InputStream input = getInputStream(conn);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            int count;
            byte[] buffer = new byte[4096];
            while ((count = input.read(buffer, 0, buffer.length)) > 0) {
                output.write(buffer, 0, count);
            }
            input.close();
            // 若已通过请求头得到charset，则不需要去html里面继续查找
            if (charset == null || charset.equals("")) {
                charset = detectCharset(output.toString());
                // 若在html里面还是未找到charset，则设置默认编码为utf-8
                if (charset == null || charset.equals("")) {
                    charset = "utf-8";
                }
            }

            result = output.toString(charset);
            output.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static String detectCharset(String input) {
        Pattern pattern = Pattern.compile("charset=\"?([\\w\\d-]+)\"?;?", Pattern.CASE_INSENSITIVE);
        if (input != null && !input.equals("")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    private static InputStream getInputStream(HttpURLConnection conn) throws Exception {
        String ContentEncoding = conn.getHeaderField("Content-Encoding");
        if (ContentEncoding != null) {
            ContentEncoding = ContentEncoding.toLowerCase();
            if (ContentEncoding.indexOf("gzip") != 1) return new GZIPInputStream(conn.getInputStream());
            else if (ContentEncoding.indexOf("deflate") != 1) return new DeflaterInputStream(conn.getInputStream());
        }

        return conn.getInputStream();
    }

    private static HttpURLConnection getConnection(String url, String method, String param, Map<String, String> header, InetSocketAddress addr, File file) throws Exception {
        HttpURLConnection conn;
        if (addr == null) conn = (HttpURLConnection) (new URL(url)).openConnection();
        else conn = (HttpURLConnection) (new URL(url)).openConnection(new Proxy(Proxy.Type.HTTP, addr));
        conn.setRequestMethod(method);
        // 这里一定要两个超时都设置，否则会发生线程永久性阻塞
        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);
        // 设置通用的请求属性
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.117 Safari/537.36");
        conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
        String ContentEncoding = null;
        if (header != null) {
            for (Entry<String, String> entry : header.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("Content-Encoding")) ContentEncoding = entry.getValue();
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        if (url.startsWith("https:")) {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            }, new java.security.SecureRandom());

            ((HttpsURLConnection) conn).setSSLSocketFactory(sslContext.getSocketFactory());
        }

        if (method == "POST") {
            conn.setDoOutput(true);
            conn.setDoInput(true);
            if (param != null && !param.equals("")) {
                OutputStream output = conn.getOutputStream();
                if (ContentEncoding != null) {
                    if (ContentEncoding.indexOf("gzip") > 0) {
                        output = new GZIPOutputStream(output);
                    } else if (ContentEncoding.indexOf("deflate") > 0) {
                        output = new DeflaterOutputStream(output);
                    }
                }
                output.write(param.getBytes());
            }

            if (file != null) {

            }
        }

        // 建立实际的连接
        conn.connect();
        return conn;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
