package com.jxph.cloud.service.auth.client.runner.annotation;

import com.jxph.cloud.service.auth.client.runner.DruidConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DruidConfig.class})
@Documented
@Inherited
public @interface EnableDruidClient {
}
