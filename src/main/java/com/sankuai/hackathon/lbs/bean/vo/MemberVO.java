package com.sankuai.hackathon.lbs.bean.vo;

import com.sankuai.hackathon.lbs.bean.po.UserPO;

/**
 * Description: MemberBVO
 * Author: qiqi
 * Create: 2015-05-22
 */
public class MemberVO {

    private Integer userId;

    private String username;

    private String nickname;

    private String avatar;

    public MemberVO(){

    }

    public MemberVO(UserPO user){
        this.userId = user.getId();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
    }

    public String getAvatar() {

        return avatar;
    }

    public void setAvatar(String avatar) {

        this.avatar = avatar;
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }
}
