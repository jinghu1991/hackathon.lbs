package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.UserActivityPO;
import org.springframework.stereotype.Repository;

/**
 * Description: IUserActivityDAO
 * Author: jinghu1991
 * Create: 2015-05-22 21:14
 */
@Repository
public interface IUserActivityDAO {

    void insert(UserActivityPO entity);

    void update(UserActivityPO entity);

    UserActivityPO getById(int id);
}
