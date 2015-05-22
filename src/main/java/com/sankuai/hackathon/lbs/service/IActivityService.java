package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.po.ActivityPO;
import com.sankuai.hackathon.lbs.bean.vo.ActivityVO;

import java.util.List;

/**
 * Description: IActivityService
 * Author: jinghu1991
 * Create: 2015-05-22 19:33
 */
public interface IActivityService {

    void createActivity(ActivityPO activityPO);

    List<ActivityVO> getActivityList(Integer groupId);

    Integer attendActivity(Integer userId, Integer activityId);
}
