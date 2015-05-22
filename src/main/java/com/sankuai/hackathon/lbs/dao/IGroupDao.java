package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: IGroupDao
 * Author: qiqi
 * Create: 2015-05-22
 */
@Repository
public interface IGroupDao {

    public List<GroupVO> getListByParam();

    public GroupPO getGroupById(Integer id);
}
