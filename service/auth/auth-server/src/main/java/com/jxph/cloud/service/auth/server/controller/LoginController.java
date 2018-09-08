package com.jxph.cloud.service.auth.server.controller;

import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.auth.api.facade.LoginFacade;
import com.jxph.cloud.service.auth.api.form.LoginForm;
import com.jxph.cloud.service.auth.client.runner.JwtHelper;
import com.jxph.cloud.service.auth.server.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/9/2 12:19
 */
@RestController
@Api("登录接口")
public class LoginController implements LoginFacade {
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private LoginService loginService;

    @ApiOperation("测试登录")
    @Override
    public ResponseResult<String> login(@RequestBody @Valid LoginForm loginForm, HttpServletResponse response) {
        String token = loginService.login(loginForm);
        response.setHeader(jwtHelper.getHeader(),token);
        return ResponseResult.ok(token);
    }


}
