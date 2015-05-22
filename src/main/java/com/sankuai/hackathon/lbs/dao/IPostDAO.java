package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.PostPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: IMessageDAO
 * Author: jinghu1991
 * Create: 2015-05-22 09:46
 */
@Repository
public interface IPostDAO {

    void insert(PostPO entity);

    void update(PostPO entity);

    PostPO getById(int id);

    List<PostPO> getByGroup(Integer groupId);
}
