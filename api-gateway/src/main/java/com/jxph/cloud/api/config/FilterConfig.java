package com.jxph.cloud.api.config;

import com.jxph.cloud.api.filter.DefaultFilter;
import com.jxph.cloud.api.filter.FastRateLimitZuulFilter;
import com.jxph.cloud.api.filter.RateLimitZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢秋豪
 * @date 2018/9/1 22:16
 */
@Configuration
public class FilterConfig {
    @Bean
    public DefaultFilter fastFilter(){
        return new DefaultFilter();
    }
    @Bean
    public RateLimitZuulFilter rateLimitZuulFilter(){
        return new RateLimitZuulFilter();
    }
    @Bean
    public FastRateLimitZuulFilter fastRateLimitZuulFilter(){
        return new FastRateLimitZuulFilter();
    }
}
