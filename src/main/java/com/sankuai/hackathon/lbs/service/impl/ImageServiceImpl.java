package com.sankuai.hackathon.lbs.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sankuai.hackathon.lbs.service.IImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Description: ImageServiceImpl
 * Author: qiqi
 * Create: 2015-05-21
 */
@Service
public class ImageServiceImpl implements IImageService {

    public static final String FILE_PATH = "/tmp/";

    private static final String ACCESS_KEY = "Faajz0-yWI4QdrILtBynJ7JGLNl96y5v1j3K7L8I";
    private static final String SECRET_KEY = "9MqReDxyQgxIyG9khnNal7yuYZJbZzmFJkeXEdqu";

    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static final String DOMAIN = "http://7xj7yj.com1.z0.glb.clouddn.com/";
    private UploadManager uploadManager = new UploadManager();

    @Override
    public String uploadImage(MultipartFile file, HttpServletRequest request) {

        String fileName = file.getOriginalFilename();
        // 后缀名
        String lastName = fileName.substring(fileName.lastIndexOf('.'));
        // 随机文件名
        fileName = UUID.randomUUID().toString().replace("-", "");
        fileName += lastName;
        File tempFile = new File(FILE_PATH + fileName);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.transferTo(tempFile);
            byte[] arr = new byte[(int) tempFile.length()];
            FileInputStream fileStream = null;

            fileStream = new FileInputStream(tempFile);
            fileStream.read(arr, 0, arr.length);
            this.upload(arr, fileName, auth.uploadToken("hack4"));

            tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DOMAIN + tempFile.getName();
    }

    public void upload(byte[] data, String key, String upToken) {

        try {
            Response res = uploadManager.put(data, key, upToken);
            if (res.isOK()) {
                System.out.println(res.bodyString());
                //success
            } else {
                //
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时简单状态信息
//            log.error(r.toString());
//            try {
//                // 响应的文本信息
////                log.error(r.bodyString());
//            } catch (QiniuException e1) {
//                //ignore
//            }
        }


    }


}
