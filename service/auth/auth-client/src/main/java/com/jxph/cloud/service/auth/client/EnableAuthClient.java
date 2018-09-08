package com.jxph.cloud.service.auth.client;


import com.jxph.cloud.service.auth.client.runner.*;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 谢秋豪
 * @date 2018/9/3 14:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DruidConfig.class, IpConfig.class, JwtHelper.class, RedisConfig.class, DistributedLock.class,SpringContextUtils.class})
@Documented
@Inherited
public @interface EnableAuthClient {
}
