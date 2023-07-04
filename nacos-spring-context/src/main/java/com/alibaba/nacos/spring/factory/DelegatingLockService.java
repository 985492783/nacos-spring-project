package com.alibaba.nacos.spring.factory;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.lock.LockService;
import com.alibaba.nacos.api.lock.listen.EventListen;
import com.alibaba.nacos.api.lock.model.LockInfo;
import com.alibaba.nacos.api.lock.model.LockInstance;

import java.util.Properties;

/**
 * @author 985492783@qq.com
 * @date 2023/7/5 2:27
 */
public class DelegatingLockService implements LockService{
    
    private LockService lockService;
    
    private Properties properties;
    public DelegatingLockService(LockService service, Properties properties) {
        this.lockService = service;
        this.properties = properties;
    }
    
    @Override
    public Boolean lock(LockInfo lockInfo) throws NacosException {
        return lockService.lock(lockInfo);
    }
    
    @Override
    public Boolean tryLock(LockInfo lockInfo, long waitTime) throws NacosException {
        return lockService.tryLock(lockInfo, waitTime);
    }
    
    @Override
    public void addListener(LockInstance instance, EventListen eventListen) throws NacosException {
        lockService.addListener(instance, eventListen);
    }
}
