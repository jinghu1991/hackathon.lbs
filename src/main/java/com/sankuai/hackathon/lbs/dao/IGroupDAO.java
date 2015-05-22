package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;
import com.sankuai.hackathon.lbs.bean.po.GroupUserPO;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Description: IGroupDao
 * Author: qiqi
 * Create: 2015-05-22
 */
@Repository
public interface IGroupDAO {

    public void insertGroup(GroupPO po);

    public List<GroupVO> getGroupPOByRange(Map<String, Object> cond);

    public List<GroupVO> getGroupByUserId(@Param("userId") Integer userId);

    public void insertMember(GroupUserPO po);

    public GroupPO getGroupById(Integer id);

    public List<GroupVO> getGroupVOById(Integer id);
}
