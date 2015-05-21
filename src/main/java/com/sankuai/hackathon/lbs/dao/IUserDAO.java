package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.PO.UserPO;
import org.springframework.stereotype.Repository;

/**
 * Description: IUserDAO
 * Author: jinghu1991
 * Create: 2015-05-21 19:53
 */
@Repository
public interface IUserDAO {

    void insert(UserPO entity);

    void update(UserPO entity);

    UserPO getById(int id);
}
