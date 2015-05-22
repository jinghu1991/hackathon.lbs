package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.ActivityPO;
import com.sankuai.hackathon.lbs.bean.vo.ActivityVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: IActivityDAO
 * Author: jinghu1991
 * Create: 2015-05-22 18:18
 */
@Repository
public interface IActivityDAO {

    void insert(ActivityPO entity);

    void update(ActivityPO entity);

    ActivityPO getById(int id);

    List<ActivityVO> getByGroup(Integer groupId);
}
