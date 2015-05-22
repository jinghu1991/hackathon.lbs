package com.sankuai.hackathon.lbs.service;

import com.sankuai.hackathon.lbs.bean.po.KankanPO;

import java.util.List;

/**
 * Description: IKankanService
 * Author: qiqi
 * Create: 2015-05-22
 */
public interface IKankanService {

    public List<KankanPO> getKankanByGroupId(Integer groupId);

}
