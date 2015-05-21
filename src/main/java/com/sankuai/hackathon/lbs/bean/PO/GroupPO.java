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

    private BigDecimal lng;

    private BigDecimal lat;

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

    public BigDecimal getLat() {

        return lat;
    }

    public void setLat(BigDecimal lat) {

        this.lat = lat;
    }

    public BigDecimal getLng() {

        return lng;
    }

    public void setLng(BigDecimal lng) {

        this.lng = lng;
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
}
