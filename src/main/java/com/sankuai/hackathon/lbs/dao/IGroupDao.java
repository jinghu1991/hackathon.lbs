package com.sankuai.hackathon.lbs.dao;

import com.sankuai.hackathon.lbs.bean.VO.GroupVO;

import java.util.List;

/**
 * Description: IGroupDao
 * Author: qiqi
 * Create: 2015-05-22
 */
public interface IGroupDao {

    public List<GroupVO> getListByParam();


}
