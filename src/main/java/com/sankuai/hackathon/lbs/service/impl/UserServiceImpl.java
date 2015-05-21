package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.UserPO;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.service.IUserService;
import com.sankuai.hackathon.lbs.util.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: UserServiceImpl
 * Author: jinghu1991
 * Create: 2015-05-21 19:58
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    IUserDAO userDAO;

    @Override
    public UserPO getUser(Integer userId) {
        return userDAO.getById(userId);
    }

    @Override
    public void saveUser(UserPO userPO) {
        userPO.setCreateTime(DateTime.now().toSqlTimestamp());
        userPO.setRecentLoginTime(DateTime.now().toSqlTimestamp());
        userPO.setOnline(1);
        userDAO.insert(userPO);
    }
}
