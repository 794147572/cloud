package com.jxph.cloud.service.fast.server.controller;

import com.jxph.cloud.common.utils.ResponseResult;

import com.jxph.cloud.service.fast.api.facade.TestFeignFacade;
import com.jxph.cloud.service.fast.server.feign.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢秋豪
 * @date 2018/9/2 12:53
 */
@RestController
public class TestFeignController implements TestFeignFacade {
    @Autowired
    private TestFeignClient testFeignClient;

    @Override
    public ResponseResult<String> testFeign(){
        //....         业务代码
        ResponseResult<String> result = testFeignClient.testFeign();
        return result;
    }
}
