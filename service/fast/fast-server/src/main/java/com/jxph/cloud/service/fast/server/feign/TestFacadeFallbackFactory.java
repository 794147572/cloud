package com.jxph.cloud.service.fast.server.feign;

import com.jxph.cloud.common.utils.ResponseResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author 谢秋豪
 * @date 2018/9/2 0:59
 */
@Component
public class TestFacadeFallbackFactory implements FallbackFactory<TestFeignClient>{

    @Override
    public TestFeignClient create(Throwable throwable) {
        return new TestFeignClientWithFactory() {
            @Override
            public ResponseResult<String> testFeign() {
                return ResponseResult.error("test 降级");
            }

            @Override
            public ResponseResult<String> token(String token) {
                return ResponseResult.error("test 降级");
            }
        };
    }
}
