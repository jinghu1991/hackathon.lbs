package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.po.PostPO;
import com.sankuai.hackathon.lbs.bean.po.VotePO;
import com.sankuai.hackathon.lbs.bean.vo.PostVO;
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
    public @ResponseBody AjaxResult createPost(Integer userid, Integer groupid, String content) {
        AjaxResult result = new AjaxResult();
        try {
            PostPO postPO = new PostPO();
            postPO.setUserId(userid);
            postPO.setGroupId(groupid);
            postPO.setContent(content);
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
    public @ResponseBody AjaxResult getGroupPost(Integer groupid, Integer userid) {
        AjaxResult result = new AjaxResult();
        try {
            List<PostVO> postPOList = postService.getPost(groupid, userid);
            result.setStatus(0);
            result.setData(postPOList);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public @ResponseBody AjaxResult votePost(Integer postid, Integer userid, Integer type) {
        AjaxResult result = new AjaxResult();
        try {
            VotePO param = new VotePO();
            param.setUserId(userid);
            param.setPostId(postid);
            param.setType(type);
            Integer voteCount = postService.votePost(param);
            result.setStatus(0);
            result.setData(voteCount);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
