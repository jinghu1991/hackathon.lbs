package com.sankuai.hackathon.lbs.bean;

/**
 * Description: ApiResult
 * Author: jinghu1991
 * Create: 2015-05-21 22:17
 */
public class ApiResult {

    private boolean success;
    private String msg;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
