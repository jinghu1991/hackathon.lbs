package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.UserPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: IUserDAO
 * Author: jinghu1991
 * Create: 2015-05-21 19:53
 */
@Repository
public interface IUserDAO {

    int insert(UserPO entity);

    void update(UserPO entity);

    UserPO getById(int id);

    UserPO getByName(String name);

    List<UserPO> getByGroup(Integer groupId);
}
