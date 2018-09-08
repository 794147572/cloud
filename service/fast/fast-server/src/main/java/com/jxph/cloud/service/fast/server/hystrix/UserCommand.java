package com.jxph.cloud.service.fast.server.hystrix;/*
package com.jxph.cloud.service.fast.hystrix;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URL;

*/
/**
 * @author 谢秋豪
 * @date 2018/9/2 0:45
 *//*

@Slf4j
@Component
public class UserCommand extends HystrixCommand<String> {
    protected UserCommand() {
        super(
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("userCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("userThreadPool"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter())
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))
        );
    }

    @Override
    protected String run() throws Exception {
        log.info("userCommand start");
        URL url = new URL("http://localhost:8001/test");
        byte[] result = new byte[1024];
        url.openStream().read(result);
        return new String(result);
    }

    @Override
    protected String getFallback() {
        return "服务降级，暂时不可用";
    }
}
*/
