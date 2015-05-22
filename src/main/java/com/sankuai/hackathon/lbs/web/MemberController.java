package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.framework.factory.AjaxResultFactory;
import com.sankuai.hackathon.lbs.service.IGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: MemberContrller
 * Author: qiqi
 * Create: 2015-05-22
 */
@RequestMapping("/member")
@Controller
public class MemberController {

    @Resource
    private IGroupService groupService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult join(Integer groupid, Integer userid) {

        AjaxResult succ = AjaxResultFactory.getSuccessResult();
        this.groupService.joinGroup(groupid, userid);

        return succ;
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult get(Integer groupid) {

        List<UserPO> userList = this.groupService.getUserByGroupId(groupid);

        AjaxResult result = AjaxResultFactory.getSuccessResult();
        result.setData(userList);

        return result;
    }


    @RequestMapping("/html")
    public String toPage(Integer groupid, Integer userid) {

        return "member";
    }


}
