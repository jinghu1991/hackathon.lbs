package com.sankuai.hackathon.lbs.dao;

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
public interface IGroupDao {

    public List<GroupVO> getGroupPOByRange(Map<String, Object> cond);

    public List<GroupVO> getGroupByUserId(@Param("userId") Integer userId);

    public void insertMember(GroupUserPO po);


}
