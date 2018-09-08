package com.jxph.cloud.service.fast.server.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/8/16 18:01
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = DataSourceConstant.DATASOURCE_NAME_FIRST)
    @ConfigurationProperties(prefix = "spring.datasource.druid.first")
    public DataSource dataSourceFirst() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = DataSourceConstant.DATASOURCE_NAME_SECOND)
    @ConfigurationProperties(prefix = "spring.datasource.druid.second")
    public DataSource dataSourceSecond() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier(DataSourceConstant.DATASOURCE_NAME_FIRST) DataSource firstDataSource,
                                        @Qualifier(DataSourceConstant.DATASOURCE_NAME_SECOND) DataSource secondDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceConstant.DATASOURCE_NAME_FIRST, firstDataSource);
        targetDataSources.put(DataSourceConstant.DATASOURCE_NAME_SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }


}
