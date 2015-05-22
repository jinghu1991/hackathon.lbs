package com.sankuai.hackathon.lbs.bean.po;

import java.sql.Timestamp;

/**
 * Description: ActivityPO
 * Author: jinghu1991
 * Create: 2015-05-22 17:49
 */
public class ActivityPO {

    private Integer id;
    private Integer groupId;
    private Integer userId;
    private String description;
    private Integer currentCount;
    private Integer maxCount;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createTime;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getGroupId(){
        return this.groupId;
    }

    public void setGroupId(Integer groupId){
        this.groupId = groupId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getCurrentCount(){
        return this.currentCount;
    }

    public void setCurrentCount(Integer currentCount){
        this.currentCount = currentCount;
    }

    public Integer getMaxCount(){
        return this.maxCount;
    }

    public void setMaxCount(Integer maxCount){
        this.maxCount = maxCount;
    }

    public Timestamp getStartTime(){
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime){
        this.startTime = startTime;
    }

    public Timestamp getEndTime(){
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime){
        this.endTime = endTime;
    }

    public Timestamp getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }
}
