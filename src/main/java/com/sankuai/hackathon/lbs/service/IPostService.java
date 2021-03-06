package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.po.PostPO;
import com.sankuai.hackathon.lbs.bean.po.VotePO;
import com.sankuai.hackathon.lbs.bean.vo.PostVO;

import java.util.Iterator;
import java.util.List;

/**
 * Description: IMessageService
 * Author: jinghu1991
 * Create: 2015-05-22 09:43
 */
public interface IPostService {

    void createPost(PostPO postPO);

    List<PostVO> getPost(Integer groupId, Integer userId);

    Integer votePost(VotePO votePO);
}
