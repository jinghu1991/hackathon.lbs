package com.sankuai.hackathon.lbs.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description: IImageService
 * Author: qiqi
 * Create: 2015-05-21
 */
public interface IImageService {

    public String uploadImage(MultipartFile file, HttpServletRequest request) throws IOException;

}
