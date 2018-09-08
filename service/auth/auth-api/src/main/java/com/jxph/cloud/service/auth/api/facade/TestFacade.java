package com.jxph.cloud.service.auth.api.facade;

import com.jxph.cloud.common.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 谢秋豪
 * @date 2018/9/2 12:50
 */
@RequestMapping("/test")
public interface TestFacade {
    @GetMapping("")
    ResponseResult<String> testFeign();
    @GetMapping("/token")
    ResponseResult<String> token(@RequestHeader("token")String token);
}
