package com.sankuai.hackathon.lbs.bean.po;

/**
 * Description: KankanPO
 * Author: qiqi
 * Create: 2015-05-22
 */
public class KankanPO {

    private Integer id;

    private String title;

    private String summary;

    private String url;

    private Integer groupId;

    private Integer status;

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

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }
}
