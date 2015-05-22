package com.sankuai.hackathon.lbs.bean.po;

import java.sql.Timestamp;

/**
 * Description: GroupPO
 * Author: qiqi
 * Create: 2015-05-21
 */
public class GroupPO {

    private Integer id;

    private String name;

    private Double longitude;  // 经度

    private Double latitude; // 纬度

    private String photo;

    private String createBy;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer canJoin;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = photo;
    }

    public Integer getCanJoin() {

        return canJoin;
    }

    public void setCanJoin(Integer canJoin) {

        this.canJoin = canJoin;
    }

    public String getCreateBy() {

        return createBy;
    }

    public void setCreateBy(String createBy) {

        this.createBy = createBy;
    }

    public Double getLatitude() {

        return latitude;
    }

    public void setLatitude(Double latitude) {

        this.latitude = latitude;
    }

    public Double getLongitude() {

        return longitude;
    }

    public void setLongitude(Double longitude) {

        this.longitude = longitude;
    }

    public Timestamp getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {

        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {

        this.updateTime = updateTime;
    }
}
