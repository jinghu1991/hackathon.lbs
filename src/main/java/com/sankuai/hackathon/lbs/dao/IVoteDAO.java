package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.po.VotePO;
import org.springframework.stereotype.Repository;

/**
 * Description: IVoteDAO
 * Author: jinghu1991
 * Create: 2015-05-22 12:49
 */
@Repository
public interface IVoteDAO {

    void insert(VotePO entity);

    void update(VotePO entity);

    VotePO getVote(VotePO param);
}
