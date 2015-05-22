package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.GroupUserPO;
import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import com.sankuai.hackathon.lbs.dao.IGroupDao;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Description: GroupServiceImpl
 * Author: qiqi
 * Create: 2015-05-22
 */
@Service
public class GroupServiceImpl implements IGroupService{

    @Resource
    private IGroupDao groupDao;

    @Resource
    private IUserDAO userDao;

    @Override
    public List<GroupVO> getGroupPOByCond(Map<String, Object> cond) {

        return groupDao.getGroupPOByCond(cond);
    }

    @Override
    public List<GroupVO> getGroupPOByUserId(Integer userId) {

        return null;
    }

    @Override
    public void joinGroup(Integer groupId, Integer userId) {

        GroupUserPO gupo = new GroupUserPO();
        gupo.setGroupId(groupId);
        gupo.setUserId(userId);

        this.groupDao.insertMember(gupo);
    }

    @Override
    public void leaveGroup(Integer groupId, Integer userId) {

    }

    @Override
    public List<UserPO> getUserByGroupId(Integer groupId){
        return this.userDao.getByGroup(groupId);
    }
}
