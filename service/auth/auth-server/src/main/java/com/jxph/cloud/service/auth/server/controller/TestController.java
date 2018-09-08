package com.jxph.cloud.service.auth.server.controller;

import com.jxph.cloud.common.annotation.Login;
import com.jxph.cloud.common.context.UserContextHolder;
import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.auth.api.facade.TestFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢秋豪
 * @date 2018/9/2 12:51
 */
@RestController
@Api("测试接口")
public class TestController implements TestFacade {
    @Override
    public ResponseResult<String> testFeign() {
        return ResponseResult.ok("feign 调用成功");
    }

    @Override
    @Login
    @ApiOperation("测试登录成功")
    public ResponseResult<String> token(@RequestHeader("token")String token) {
        String userName = UserContextHolder.getUserName();
        return ResponseResult.ok(userName);
    }
}
