package com.sankuai.hackathon.lbs.bean.po;

import java.sql.Timestamp;

/**
 * Description: UserPO
 * Author: jinghu1991
 * Create: 2015-05-21 19:52
 */
public class UserPO {
    private Integer id;
    private String username;
    private String avatar;
    private String nickname;
    private String password;
    private String email;
    private Integer online;
    private Timestamp createTime;
    private Timestamp recentLoginTime;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getAvatar(){
        return this.avatar;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Integer getOnline(){
        return this.online;
    }

    public void setOnline(Integer online){

        this.online = online;
    }

    public Timestamp getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }

    public Timestamp getRecentLoginTime(){
        return this.recentLoginTime;
    }

    public void setRecentLoginTime(Timestamp recentLoginTime){
        this.recentLoginTime = recentLoginTime;
    }
}
