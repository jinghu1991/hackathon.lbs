package com.sankuai.hackathon.lbs.bean.po;

import java.sql.Timestamp;

/**
 * Description: GroupUserPO
 * Author: qiqi
 * Create: 2015-05-22
 */
public class GroupUserPO {

    private Integer id;

    private Integer groupId;

    private Integer userId;

    private Timestamp createTime;

    public Integer getGroupId() {

        return groupId;
    }

    public void setGroupId(Integer groupId) {

        this.groupId = groupId;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public Timestamp getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {

        this.createTime = createTime;
    }
}
