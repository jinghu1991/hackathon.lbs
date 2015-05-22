package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.framework.factory.AjaxResultFactory;
import com.sankuai.hackathon.lbs.service.IImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: FileUploadController
 * Author: qiqi
 * Create: 2015-05-21
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Resource
    private IImageService imageService;

    @RequestMapping("/test")
    public String goTestPage() {

        return "/test";
    }


    @RequestMapping("/uploadImg")
    @ResponseBody
    public AjaxResult uploadImage(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fileName = imageService.uploadImage(file, request);

        Map<String, String> resultMap = new HashMap<String, String>(1);
        resultMap.put("url", fileName);
        AjaxResult result = AjaxResultFactory.getSuccessResult();
        result.setData(resultMap);

        return result;

    }

}
