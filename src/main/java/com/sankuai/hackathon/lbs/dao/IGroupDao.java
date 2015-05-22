package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.GroupUserPO;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Description: IGroupDao
 * Author: qiqi
 * Create: 2015-05-22
 */
@Repository
public interface IGroupDao {

    public List<GroupVO> getGroupPOByCond(Map<String, Object> cond);

    public void insertMember(GroupUserPO po);


}
