package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.po.PostPO;
import com.sankuai.hackathon.lbs.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: MessageController
 * Author: jinghu1991
 * Create: 2015-05-22 09:43
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Resource
    IPostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AjaxResult createPost(PostPO postPO) {
        AjaxResult result = new AjaxResult();
        try {
            postService.createPost(postPO);
            result.setStatus(0);
            result.setData(postPO);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody AjaxResult getGroupPost(Integer groupId) {
        AjaxResult result = new AjaxResult();
        try {
            List<PostPO> postPOList = postService.getPost(groupId);
            result.setStatus(0);
            result.setData(postPOList);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
