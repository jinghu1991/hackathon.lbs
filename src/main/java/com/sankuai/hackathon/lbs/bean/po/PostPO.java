package com.sankuai.hackathon.lbs.bean.po;

import java.sql.Timestamp;

/**
 * Description: MessagePO
 * Author: jinghu1991
 * Create: 2015-05-22 09:45
 */
public class PostPO {
    private Integer id;
    private Integer userId;
    private Integer groupId;
    private String content;
    private Integer status;
    private Integer voteCount;
    private Timestamp createTime;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getGroupId(){
        return this.groupId;
    }

    public void setGroupId(Integer groupId){
        this.groupId = groupId;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getVoteCount(){
        return this.voteCount;
    }

    public void setVoteCount(Integer voteCount){
        this.voteCount = voteCount;
    }

    public Timestamp getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }
}
