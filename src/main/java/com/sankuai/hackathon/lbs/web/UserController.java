package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.pobeans.UserPO;
import com.sankuai.hackathon.lbs.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description: UserController
 * Author: jinghu1991
 * Create: 2015-05-21 20:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody AjaxResult getUser(UserPO param) {
        AjaxResult result = new AjaxResult();
        try {
            UserPO userPO = userService.getUser(param);
            result.setStatus(0);
            result.setData(userPO);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AjaxResult createUser(UserPO userPO) {
        AjaxResult result = new AjaxResult();
        try {
            userService.saveUser(userPO);
            result.setStatus(0);
            result.setData(userPO);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
