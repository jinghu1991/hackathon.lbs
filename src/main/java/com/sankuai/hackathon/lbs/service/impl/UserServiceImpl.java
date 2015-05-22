package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.service.IUserService;
import com.sankuai.hackathon.lbs.util.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;

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
    public void saveUser(UserPO userPO) {
        userPO.setCreateTime(DateTime.now().toSqlTimestamp());
        userPO.setRecentLoginTime(DateTime.now().toSqlTimestamp());
        userPO.setOnline(1);
        userDAO.insert(userPO);
    }

    @Override
    public UserPO getUser(UserPO param) {
        if(param.getId() != null) {
            UserPO userPO = userDAO.getById(param.getId());
            if(userPO == null) {
                throw new RuntimeException("user does not exit!");
            }
            return userPO;
        }
        if(param.getUsername() == null &&  param.getPassword() == null ) {
            throw new InvalidParameterException("name and password can not be null!");
        }
        UserPO userPO = userDAO.getByName(param.getUsername());
        if(userPO == null) {
            throw new RuntimeException("user does not exist!");
        } else if(param.getPassword().equals(userPO.getPassword())) {
            userPO.setOnline(1);
            userPO.setRecentLoginTime(DateTime.now().toSqlTimestamp());
            userDAO.update(userPO);
            return userPO;
        } else {
            throw new RuntimeException("password is wrong!");
        }
    }

    @Override
    public Integer checkExist(String userName) {
        if(userDAO.getByName(userName) != null) {
            throw new RuntimeException("user already exist!");
        } else {
            return 0;
        }
    }
}
