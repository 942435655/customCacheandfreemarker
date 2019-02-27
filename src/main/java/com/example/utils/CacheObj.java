package com.example.utils;

import com.example.utils.ConcurrentHashMapCacheUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C), 2015-2019, XXX有限公司
 * @FileName: CacheObj
 * @author: 唐涛
 * @Date: 2019/2/26 21:57
 * @Description: 封装缓存实体类
 * @since 1.0.0
 */
@Component
class CacheObj {
    /**
     * 缓存对象
     */
    private Object CacheValue;
    /**
     * 缓存过期时间
     */
    private Long ttlTime;

    CacheObj(Object cacheValue, Long ttlTime) {
        CacheValue = cacheValue;
        this.ttlTime = ttlTime;
    }

    Object getCacheValue() {
        return CacheValue;
    }

    Long getTtlTime() {
        return ttlTime;
    }

    @Override
    public String toString() {
        return "CacheObj{" +
                "CacheValue=" + CacheValue +
                ", ttlTime=" + ttlTime +
                '}';
    }
}

/**
 * 每一分钟清理一次过期缓存
 */
@Component
class CleanTimeOutThread implements Runnable{

    @Override
    public void run() {
        ConcurrentHashMapCacheUtils.setCleanThreadRun();
        while (true) {
            System.out.println("clean thread run ");
            ConcurrentHashMapCacheUtils.deleteTimeOut();
            try {
                Thread.sleep(ConcurrentHashMapCacheUtils.ONE_MINUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

