package com.sankuai.hackathon.lbs.bean.po;

/**
 * Description: VotePO
 * Author: jinghu1991
 * Create: 2015-05-22 12:37
 */
public class VotePO {
    private Integer postId;
    private Integer userId;
    private Integer type;

    public Integer getPostId(){
        return this.postId;
    }

    public void setPostId(Integer postId){
        this.postId = postId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getType(){
        return this.type;
    }

    public void setType(Integer type){
        this.type = type;
    }
}
