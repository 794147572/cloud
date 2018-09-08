package com.jxph.cloud.service.auth.server.config.datasource;

/**
 * @author 谢秋豪
 * @date 2018/8/31 23:25
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }

    public static String  getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
