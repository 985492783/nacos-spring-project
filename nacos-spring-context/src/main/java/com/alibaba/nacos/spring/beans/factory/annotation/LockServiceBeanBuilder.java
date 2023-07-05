package com.alibaba.nacos.spring.beans.factory.annotation;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.lock.LockService;
import com.alibaba.nacos.spring.factory.NacosServiceFactory;
import com.alibaba.nacos.spring.util.GlobalNacosPropertiesSource;

import java.util.Properties;

/**
 * @author qiyue.zhang@aloudata.com
 * @description LockServiceBeanBuilder
 * @date 2023/7/5 17:14
 */
public class LockServiceBeanBuilder
        extends AbstractNacosServiceBeanBuilder<LockService> {
    
    public static final String BEAN_NAME = "lockServiceBeanBuilder";
    
    protected LockServiceBeanBuilder() {
        super(GlobalNacosPropertiesSource.LOCK);
    }
    
    @Override
    protected LockService createService(NacosServiceFactory nacosServiceFactory, Properties properties)
            throws NacosException {
        return nacosServiceFactory.createLockService(properties);
    }
}
