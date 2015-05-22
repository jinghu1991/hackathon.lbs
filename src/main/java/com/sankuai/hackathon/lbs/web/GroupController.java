package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import com.sankuai.hackathon.lbs.framework.factory.AjaxResultFactory;
import com.sankuai.hackathon.lbs.service.IGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: GroupController
 * Author: qiqi
 * Create: 2015-05-22
 */
@RequestMapping("/group")
@Controller
public class GroupController {

    @Resource
    private IGroupService groupService;


    @RequestMapping("/groupByUserId")
    @ResponseBody
    public AjaxResult getByUserId(Integer userid) {

        if(userid == null){
            return AjaxResultFactory.getFailureResult();
        }

        List<GroupVO> list = this.groupService.getGroupPOByUserId(userid);

        AjaxResult result = AjaxResultFactory.getSuccessResult();
        result.setData(list);

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult getGroupById(Integer groupid) {

        GroupVO groupVO = this.groupService.getGroupVOById(groupid);

        AjaxResult result = null;
        if (groupVO == null) {
            result = AjaxResultFactory.getFailureResult();
        } else {
            result = AjaxResultFactory.getSuccessResult();
            result.setData(groupVO);
        }

        return result;
    }


    // _neLng=53.3
    // _swLng=4
    // _swLat=73.40
    // _neLat=135.05
    @RequestMapping("/groupByBounds")
    @ResponseBody
    public AjaxResult groupByBounds(Double _swLng, Double _neLng, Double _swLat, Double _neLat) {

        Map<String, Object> cond = new HashMap<String, Object>();

        cond.put("swLng", _swLng);
        cond.put("neLng", _neLng);
        cond.put("swLat", _swLat);
        cond.put("neLat", _neLat);

        List<GroupVO> poList = this.groupService.getGroupPOByCond(cond);

        AjaxResult result = AjaxResultFactory.getSuccessResult();
        result.setData(poList);


        return result;
    }


}
