package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.UserPO;
import com.sankuai.hackathon.lbs.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public UserPO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }
}
