package com.jxph.cloud.service.fast.server.feign;

import com.jxph.cloud.service.auth.api.facade.TestFacade;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 谢秋豪
 * @date 2018/9/2 12:52
 */
@FeignClient(value="auth", fallbackFactory = TestFacadeFallbackFactory.class)
public interface TestFeignClient extends TestFacade {
}
