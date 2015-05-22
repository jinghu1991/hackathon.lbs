package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;

import java.util.List;

/**
 * Description: IGroupService
 * Author: qiqi
 * Create: 2015-05-21
 */
public interface IGroupService {

    public List<GroupPO> getGroupPOByParam();

    public List<GroupPO> getGroupPOByUserId(Integer userId);

    public void joinGroup(Integer groupId, Integer userId);

    public void leaveGroup(Integer groupId, Integer userId);

    // group_user
    // id
    // group_id
    // user_id
    // join time

}
