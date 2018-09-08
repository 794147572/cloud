package com.jxph.cloud.service.fast.server.config.datasource.aspect;

import com.jxph.cloud.service.fast.server.config.datasource.DataSourceContextHolder;
import com.jxph.cloud.service.fast.server.config.datasource.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 谢秋豪
 * @date 2018/8/31 23:40
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect {
    @Pointcut("@annotation(com.jxph.cloud.service.fast.server.config.datasource.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public void around(ProceedingJoinPoint point) {
        String methodName = null;
        try{
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            methodName = method.getName();
            DataSource annotation = method.getAnnotation(DataSource.class);
            DataSourceContextHolder.setDataSource(annotation.value());
            point.proceed();
        } catch (Throwable throwable) {
            log.error("routing dataSource error,methodName:{},exception:{}",methodName,throwable);
        } finally {
            DataSourceContextHolder.clearDataSource();
            log.info("clear dataSource");
        }
    }

}
