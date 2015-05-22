package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.ActivityPO;
import com.sankuai.hackathon.lbs.bean.po.GroupPO;
import com.sankuai.hackathon.lbs.bean.po.UserActivityPO;
import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.bean.vo.ActivityVO;
import com.sankuai.hackathon.lbs.dao.IActivityDAO;
import com.sankuai.hackathon.lbs.dao.IGroupDAO;
import com.sankuai.hackathon.lbs.dao.IUserActivityDAO;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.service.IActivityService;
import com.sankuai.hackathon.lbs.util.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Description: ActivityServiceImpl
 * Author: jinghu1991
 * Create: 2015-05-22 19:40
 */
@Service
public class ActivityServiceImpl implements IActivityService{

    @Resource
    IActivityDAO activityDAO;

    @Resource
    IUserActivityDAO userActivityDAO;

    @Resource
    IUserDAO userDAO;

    @Resource
    IGroupDAO groupDAO;

    @Override
    public void createActivity(ActivityPO activityPO) {
        UserPO userPO = userDAO.getById(activityPO.getUserId());
        GroupPO groupPO = groupDAO.getGroupById(activityPO.getGroupId());
        if(userPO == null || groupPO == null) {
            throw new InvalidParameterException("invalid parameter!");
        }
        activityPO.setId(null);
        activityPO.setCreateTime(DateTime.now().toSqlTimestamp());
        activityPO.setCurrentCount(0);
        activityDAO.insert(activityPO);
    }

    @Override
    public List<ActivityVO> getActivityList(Integer groupId) {
        List<ActivityVO> result = activityDAO.getByGroup(groupId);
        for(ActivityVO activityVO : result) {
            activityVO.setAttends(activityDAO.getAttends(activityVO.getId()));
        }
        return result;
    }

    @Override
    public Integer attendActivity(Integer userId, Integer activityId) {
        UserPO userPO = userDAO.getById(userId);
        ActivityPO activityPO = activityDAO.getById(activityId);
        if(userPO == null || activityPO == null) {
            throw new InvalidParameterException("invalid parameter!");
        }
        if(activityPO.getCurrentCount().compareTo(activityPO.getMaxCount()) >= 0) {
            throw new RuntimeException("attends can not expire maxCount!");
        }
        activityPO.setCurrentCount(activityPO.getCurrentCount() + 1);
        UserActivityPO userActivityPO = new UserActivityPO();
        userActivityPO.setUserId(userId);
        userActivityPO.setActivityId(activityId);
        userActivityDAO.insert(userActivityPO);
        activityDAO.update(activityPO);
        return activityPO.getCurrentCount();
    }
}
