package com.sankuai.hackathon.lbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: IndexController
 * Author: liuzhao
 * Create: 2014-12-17 16:57
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    @ResponseBody
    public String index(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/400")
    public void badRequest() {
    }

    @RequestMapping("/401")
    public void unauthorized() {
    }

    @RequestMapping("/403")
    public void forbidden() {
    }

    @RequestMapping("/404")
    public void notFound() {
    }

    @RequestMapping("/500")
    public void exception() {
    }
}
