package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.ApiResult;
import com.sankuai.hackathon.lbs.bean.UserPO;
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
@RequestMapping("/users")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ApiResult getUser(@PathVariable Integer id) {
        ApiResult result = new ApiResult();
        try {
            UserPO userPO = userService.getUser(id);
            result.setSuccess(true);
            result.setData(userPO);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ApiResult createUser(UserPO userPO) {
        ApiResult result = new ApiResult();
        try {
            userService.saveUser(userPO);
            result.setSuccess(true);
            result.setData(userPO);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
