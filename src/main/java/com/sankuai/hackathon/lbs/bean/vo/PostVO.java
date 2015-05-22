package com.sankuai.hackathon.lbs.bean.vo;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;
import com.sankuai.hackathon.lbs.bean.po.UserPO;

/**
 * Description: PostVO
 * Author: jinghu1991
 * Create: 2015-05-22 18:26
 */
public class PostVO {

    private Integer id;
    private UserPO user;
    private GroupPO group;
    private String content;
    private Integer voteCount;
    private Integer voted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserPO getUser() {
        return user;
    }

    public void setUser(UserPO user) {
        this.user = user;
    }

    public GroupPO getGroup() {
        return group;
    }

    public void setGroup(GroupPO group) {
        this.group = group;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getVoted() {
        return voted;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }
}
