package com.sankuai.hackathon.lbs.bean.PO;

import java.math.BigDecimal;

/**
 * Description: GroupPO
 * Author: qiqi
 * Create: 2015-05-21
 */
public class GroupPO {

    private Integer id;

    private String name;

    private BigDecimal longitude;  // 经度

    private BigDecimal latitude; // 纬度

    private String photo;

    private String createBy;

    private String createTime;

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

    public String getCreateTime() {

        return createTime;
    }

    public void setCreateTime(String createTime) {

        this.createTime = createTime;
    }

    public BigDecimal getLatitude() {

        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {

        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {

        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {

        this.longitude = longitude;
    }
}
