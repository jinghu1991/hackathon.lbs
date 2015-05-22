package com.sankuai.hackathon.lbs.web;

import com.sankuai.hackathon.lbs.bean.AjaxResult;
import com.sankuai.hackathon.lbs.bean.po.KankanPO;
import com.sankuai.hackathon.lbs.framework.factory.AjaxResultFactory;
import com.sankuai.hackathon.lbs.service.IKankanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: KankanController
 * Author: qiqi
 * Create: 2015-05-22
 */
@Controller
@RequestMapping("/kankan")
public class KankanController {

    @Resource
    private IKankanService kankanService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult getKankan(Integer groupid){

        List<KankanPO> poList =  this.kankanService.getKankanByGroupId(groupid);

        AjaxResult result = AjaxResultFactory.getSuccessResult();
        result.setData(poList);

        return result;
    }
}
