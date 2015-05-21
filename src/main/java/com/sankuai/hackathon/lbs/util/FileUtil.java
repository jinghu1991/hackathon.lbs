package com.sankuai.hackathon.lbs.util;

import java.io.*;
import java.util.Properties;


/**
 * Description: FileUtil
 * Author: liuzhao
 * Create: 2014-11-26 13:34
 */
public class FileUtil {
    public static String read(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void save(String file, String content) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String read(InputStream in, String charset) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void delete(String path) {
        File file = new File(path);
        file.delete();
    }

    /**
     * 获取classpath根目录
     *
     * @return
     */
    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        if (path.startsWith("file:/")) return path.substring(5);
        else return path;
    }

    public static Properties loadPropertyFile(String file) {
        try {
            if (file.startsWith("classpath:")) file = getClassPath() + file.substring(10);
            FileInputStream fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            fis.close();
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void savePropertyFile(Properties prop, String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            prop.store(fos, null);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public static String getDir(String path, String pattern) {
        File baseDir = new File(path);
        if (baseDir.exists() && baseDir.isDirectory()) {
            for (File dir : baseDir.listFiles()) {
                if (dir.getName().equalsIgnoreCase(pattern)) {
                    return dir.getAbsolutePath();
                }
            }
            for (File dir : baseDir.listFiles()) {
                if (dir.isDirectory()) {
                    String target = getDir(dir.getAbsolutePath(), pattern);
                    if (target != null) return target;
                }
            }
        }
        return null;
    }
}
