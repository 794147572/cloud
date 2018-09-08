package com.jxph.cloud.service.auth.client.runner;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 谢秋豪
 * @date 2018/9/3 0:37
 */
@Component
public class DistributedLock {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    public Boolean tryLock(String key,int timeout) {
        long expires = System.currentTimeMillis() + timeout;
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, expires);
        if (flag) {
            redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
            return true;
        }
        Object currentValue = redisTemplate.opsForValue().get(key);
        if (currentValue != null && Long.parseLong(currentValue.toString()) < System.currentTimeMillis()) {
            Object oldValue = redisTemplate.opsForValue().getAndSet(key, expires);
            if (oldValue == null) {
                redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
                return true;
            } else {
                if (StringUtils.equals(currentValue.toString(), oldValue.toString())) {
                    redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
                    return true;
                }
            }
        }
        return false;
    }
}
