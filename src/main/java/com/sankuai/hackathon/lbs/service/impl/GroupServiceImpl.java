package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.GroupUserPO;
import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.bean.vo.GroupVO;
import com.sankuai.hackathon.lbs.bean.vo.MemberVO;
import com.sankuai.hackathon.lbs.dao.IGroupDAOD;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
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
    private IGroupDAOD groupDao;

    @Resource
    private IUserDAO userDao;

    @Override
    public List<GroupVO> getGroupPOByCond(Map<String, Object> cond) {

        List<GroupVO> voList = groupDao.getGroupPOByRange(cond);
        renderGroupVO(voList);

        return voList;
    }

    @Override
    public GroupVO getGroupVOById(Integer groupId) {

        List<GroupVO> voList = this.groupDao.getGroupVOById(groupId);
        renderGroupVO(voList);
        if(voList != null && voList.size() > 0){
            return voList.get(0);
        }

        return null;
    }

    @Override
    public List<GroupVO> getGroupPOByUserId(Integer userId) {

        List<GroupVO> voList = this.groupDao.getGroupByUserId(userId);
        renderGroupVO(voList);

        return voList;

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
    public List<MemberVO> getUserByGroupId(Integer groupId){

        List<MemberVO> memberList = this.convertUserToMember(this.userDao.getByGroup(groupId));

        return memberList;
    }

    private List<GroupVO> renderGroupVO(List<GroupVO> orgList){
        if(orgList != null && orgList.size() > 0){
            for(GroupVO vo: orgList){
                Integer groupId = vo.getId();
                List<MemberVO> memberList = this.getUserByGroupId(groupId);
                vo.setMembers(memberList);

                vo.getLocation().add(vo.getLongitude());
                vo.getLocation().add(vo.getLatitude());

            }
        }
        return orgList;
    }

    private List<MemberVO> convertUserToMember(List<UserPO> userList){
        if(userList != null && userList.size() > 0){
            List<MemberVO> voList = new ArrayList<MemberVO>(userList.size());
            for(UserPO po: userList){
                MemberVO vo = new MemberVO(po);
                voList.add(vo);
            }
            return voList;
        }

        return Collections.emptyList();

    }
}
