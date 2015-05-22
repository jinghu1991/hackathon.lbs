package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;
import com.sankuai.hackathon.lbs.bean.po.PostPO;
import com.sankuai.hackathon.lbs.bean.po.UserPO;
import com.sankuai.hackathon.lbs.bean.po.VotePO;
import com.sankuai.hackathon.lbs.bean.vo.PostVO;
import com.sankuai.hackathon.lbs.dao.IGroupDAO;
import com.sankuai.hackathon.lbs.dao.IPostDAO;
import com.sankuai.hackathon.lbs.dao.IUserDAO;
import com.sankuai.hackathon.lbs.dao.IVoteDAO;
import com.sankuai.hackathon.lbs.service.IPostService;
import com.sankuai.hackathon.lbs.util.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Description: MessageServiceImpl
 * Author: jinghu1991
 * Create: 2015-05-22 09:44
 */
@Service
public class PostServiceImpl implements IPostService {

    @Resource
    IPostDAO postDAO;

    @Resource
    IVoteDAO voteDAO;

    @Resource
    IUserDAO userDAO;

    @Resource
    IGroupDAO groupDAO;

    @Override
    public void createPost(PostPO postPO) {
        UserPO userPO = userDAO.getById(postPO.getUserId());
        GroupPO groupPO = groupDAO.getGroupById(postPO.getGroupId());
        if(userPO == null || groupPO == null) {
            throw new InvalidParameterException("invalid parameter!");
        }
        postPO.setStatus(1);
        postPO.setVoteCount(0);
        postPO.setCreateTime(DateTime.now().toSqlTimestamp());
        postDAO.insert(postPO);
    }

    @Override
    public List<PostVO> getPost(Integer groupId, Integer userId) {
        List<PostVO> result = postDAO.getByGroup(groupId);
        for(PostVO postVO : result) {
            VotePO param = new VotePO();
            param.setPostId(postVO.getId());
            param.setUserId(userId);
            VotePO votePO = voteDAO.getVote(param);
            if(votePO != null) {
                postVO.setVoted(votePO.getType());
            } else {
                postVO.setVoted(0);
            }
        }
        return result;
    }

    @Override
    public Integer votePost(VotePO votePO) {
        PostPO postPO = postDAO.getById(votePO.getPostId());
        UserPO userPO = userDAO.getById(votePO.getUserId());
        if(voteDAO.getVote(votePO) != null) {
            throw new RuntimeException("already voted!");
        }
        if(postPO == null || userPO == null) {
            throw new InvalidParameterException("invalid parameter!");
        }
        if(votePO.getType().equals(1)) {
            postPO.setVoteCount(postPO.getVoteCount() + 1);
        } else if(votePO.getType().equals(-1)) {
            postPO.setVoteCount(postPO.getVoteCount() - 1);
        } else {
            throw new InvalidParameterException("invalid parameter!");
        }
        postDAO.update(postPO);
        voteDAO.insert(votePO);
        return postPO.getVoteCount();
    }
}
