package com.jxph.cloud.service.fast.server.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢秋豪
 * @date 2018/9/1 20:54
 */
@Configuration
public class HystrixConfig {
    @Bean
    public HystrixCommandAspect hystrixCommandAspect(){
        return new HystrixCommandAspect();
    }

    /*@Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }*/
}

