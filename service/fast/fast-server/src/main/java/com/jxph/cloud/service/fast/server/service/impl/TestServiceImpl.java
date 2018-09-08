package com.jxph.cloud.service.fast.server.service.impl;

import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.fast.server.config.datasource.DataSourceConstant;
import com.jxph.cloud.service.fast.server.config.datasource.DataSourceContextHolder;
import com.jxph.cloud.service.fast.server.config.datasource.annotation.DataSource;
import com.jxph.cloud.service.fast.server.feign.TestFeignClient;
import com.jxph.cloud.service.fast.server.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:53
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private TestFeignClient testFeignClient;

    @Override
    @DataSource(DataSourceConstant.DATASOURCE_NAME_SECOND)
    public ResponseResult<String> testFeign() {
        ResponseResult<String> result = testFeignClient.testFeign();
        log.info(DataSourceContextHolder.getDataSource());
        return result;
    }
}
