package com.sankuai.hackathon.lbs.dao;

import org.springframework.stereotype.Repository;

/**
 * Description: IDemoDAO
 * Author: liuzhao
 * Create: 2014-09-12 15:56
 */
@Repository
public interface IDemoDAO {

    /**
     * 插入
     *
     * @param entity
     */
    public void insert(Object entity);

    /**
     * 更新
     *
     * @param entity
     */
    public void update(Object entity);


}
