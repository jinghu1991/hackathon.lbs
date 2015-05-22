package com.sankuai.hackathon.lbs.bean.po;

/**
 * Description: UserActivityPO
 * Author: jinghu1991
 * Create: 2015-05-22 21:12
 */
public class UserActivityPO {
    private Integer id;
    private Integer userId;
    private Integer activityId;

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

    public Integer getActivityId(){
        return this.activityId;
    }

    public void setActivityId(Integer activityId){
        this.activityId = activityId;
    }
}
