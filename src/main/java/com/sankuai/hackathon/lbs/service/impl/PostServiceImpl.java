package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.PostPO;
import com.sankuai.hackathon.lbs.dao.IPostDAO;
import com.sankuai.hackathon.lbs.service.IPostService;
import com.sankuai.hackathon.lbs.util.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public void createPost(PostPO postPO) {
        postPO.setStatus(1);
        postPO.setVoteCount(0);
        postPO.setCreateTime(DateTime.now().toSqlTimestamp());
        postDAO.insert(postPO);
    }

    public List<PostPO> getPost(Integer groupId) {
        return postDAO.getByGroup(groupId);
    }

    public void votePost(Integer postId, Integer userId) {

    }
}
