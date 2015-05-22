package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.po.UserPO;

/**
 * Description: IUserService
 * Author: jinghu1991
 * Create: 2015-05-21 19:57
 */
public interface IUserService {

    UserPO getUser(Integer userId);

    void saveUser(UserPO userPO);
}
