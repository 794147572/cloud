package com.jxph.cloud.service.auth.server.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/8/31 23:16
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    public DynamicDataSource(DataSource defaultDataSource, Map<Object,Object> map){
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(map);
        super.afterPropertiesSet();
    }

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
