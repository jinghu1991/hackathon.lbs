package com.sankuai.hackathon.lbs.framework.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Description: MyBatisInterceptor 处理Mysql主从分离，读写分离，query 读slave，update 读写master
 * Author: liuzhao
 * Create: 2014-09-29 15:48
 */
@Component
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyBatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getMethod().getName().equals("query")) {
            MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
            if (ms.getSqlCommandType() == SqlCommandType.SELECT && ms.getId().startsWith("com.sankuai.hackathon.lbs.dao.IOperationLogDAO")) {
                MultipleDataSource.setSlave();
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
//        if (target instanceof Executor) {
//            MultipleDataSource.setMaster();
//        }
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

}