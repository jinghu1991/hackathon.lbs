package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.po.ActivityPO;
import com.sankuai.hackathon.lbs.bean.vo.ActivityVO;
import com.sankuai.hackathon.lbs.service.IActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: ActivityController
 * Author: jinghu1991
 * Create: 2015-05-22 19:33
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Resource
    IActivityService activityService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AjaxResult createActivity(Integer userid, Integer groupid, String content, Integer maxCount) {
        AjaxResult result = new AjaxResult();
        try {
            ActivityPO activityPO = new ActivityPO();
            activityPO.setUserId(userid);
            activityPO.setGroupId(groupid);
            activityPO.setDescription(content);
            activityPO.setMaxCount(maxCount);
            activityService.createActivity(activityPO);
            result.setStatus(0);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody AjaxResult getActivity(Integer groupid) {
        AjaxResult result = new AjaxResult();
        try {
            List<ActivityVO> activityVOList = activityService.getActivityList(groupid);
            result.setStatus(0);
            result.setData(activityVOList);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/attend", method = RequestMethod.POST)
    public @ResponseBody AjaxResult attendActivity(Integer userid, Integer activityid) {
        AjaxResult result = new AjaxResult();
        try {
            Integer currentCount = activityService.attendActivity(userid, activityid);
            result.setStatus(0);
            result.setData(currentCount);
        } catch (Exception ex) {
            result.setStatus(-1);
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
