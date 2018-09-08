package com.jxph.cloud.service.auth.client.runner;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.servlet.Servlet;

/**
 * @author 谢秋豪
 * @date 2018/9/3 14:47
 */
@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //白名单
        servletServletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        servletServletRegistrationBean.addInitParameter("deny", "192.168.11.100");
        servletServletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletServletRegistrationBean.addInitParameter("loginPassword", "admin");
        servletServletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean startFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.icon,/druid/**");
        return filterRegistrationBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
