package com.sankuai.hackathon.lbs.framework.factory;

import com.sankuai.hackathon.lbs.bean.AjaxResult;

/**
 * Description: factory
 * Author: qiqi
 * Create: 2015-05-22
 */
public class AjaxResultFactory {


    public static AjaxResult getSuccessResult(){
        AjaxResult result = new AjaxResult();
        result.setStatus(0);
        result.setMsg("success");
        return result;
    }
}
