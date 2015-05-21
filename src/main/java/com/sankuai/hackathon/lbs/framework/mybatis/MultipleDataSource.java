package com.sankuai.hackathon.lbs.framework.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Description: MyBatis主从动态切换
 * Author: liuzhao
 * Create: 2014-09-29 10:44
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(MultipleDataSource.class);
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setMaster() {
        logger.debug("set to master");
        dataSourceKey.set("masterDataSource");
    }

    public static void setSlave() {
        logger.debug("set to slave");
        dataSourceKey.set("slaveDataSource");
    }


    @Override
    protected Object determineCurrentLookupKey() {
        try {
            logger.debug("invoke " + dataSourceKey.get());
            return dataSourceKey.get();
        } finally {
            setMaster();
        }
    }
}