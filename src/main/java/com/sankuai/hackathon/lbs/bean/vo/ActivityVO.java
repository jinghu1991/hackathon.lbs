package com.sankuai.hackathon.lbs.bean.vo;

import com.sankuai.hackathon.lbs.bean.po.UserPO;

import java.util.List;

/**
 * Description: ActivityVO
 * Author: jinghu1991
 * Create: 2015-05-22 19:58
 */
public class ActivityVO {

    private Integer id;
    private UserPO user;
    private String content;
    private List<UserPO> attends;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<UserPO> getAttends() {
        return attends;
    }

    public void setAttends(List<UserPO> attends) {
        this.attends = attends;
    }
}
