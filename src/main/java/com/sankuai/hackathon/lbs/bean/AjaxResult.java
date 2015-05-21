package com.sankuai.hackathon.lbs.bean;

/**
 * Description: AjaxResult
 * Author: qiqi
 * Create: 2015-05-21
 */
public class AjaxResult {

    private Integer status; // 状态

    private String msg; // 消息

    private Object data; // 数据

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }
}
