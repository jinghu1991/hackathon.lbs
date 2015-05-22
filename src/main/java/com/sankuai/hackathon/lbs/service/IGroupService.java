package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import com.sankuai.hackathon.lbs.bean.vo.MemberVO;

import java.util.List;
import java.util.Map;

/**
 * Description: IGroupService
 * Author: qiqi
 * Create: 2015-05-21
 */
public interface IGroupService {

    public List<GroupVO> getGroupPOByCond(Map<String, Object> cond);

    public GroupVO getGroupVOById(Integer groupId);

    public List<GroupVO> getGroupPOByUserId(Integer userId);

    public void joinGroup(Integer groupId, Integer userId);

    public void leaveGroup(Integer groupId, Integer userId);

    public List<MemberVO> getUserByGroupId(Integer groupId);

}
