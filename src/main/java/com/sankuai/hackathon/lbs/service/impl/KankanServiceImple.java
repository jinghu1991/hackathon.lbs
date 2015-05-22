package com.sankuai.hackathon.lbs.service.impl;

import com.sankuai.hackathon.lbs.bean.po.KankanPO;
import com.sankuai.hackathon.lbs.dao.IKankanDao;
import com.sankuai.hackathon.lbs.service.IKankanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: KankanServiceImple
 * Author: qiqi
 * Create: 2015-05-22
 */
@Service
public class KankanServiceImple implements IKankanService {

    @Resource
    private IKankanDao kankanDao;

    @Override
    public List<KankanPO> getKankanByGroupId(Integer groupId) {

        return this.kankanDao.getByGroupId(groupId);

    }
}
