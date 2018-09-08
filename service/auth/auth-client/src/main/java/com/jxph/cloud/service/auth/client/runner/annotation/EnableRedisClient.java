package com.jxph.cloud.service.auth.client.runner.annotation;

import com.jxph.cloud.service.auth.client.runner.DistributedLock;
import com.jxph.cloud.service.auth.client.runner.RedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({RedisConfig.class, DistributedLock.class})
@Documented
@Inherited
public @interface EnableRedisClient {
}
