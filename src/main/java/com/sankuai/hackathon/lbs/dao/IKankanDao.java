package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.KankanPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: IKankanDao
 * Author: qiqi
 * Create: 2015-05-22
 */
@Repository
public interface IKankanDao {

    public List<KankanPO> getByGroupId(@Param("groupId") Integer groupId);

}
