package com.jxph.cloud.service.auth.server.controller;

import com.jxph.cloud.common.annotation.Login;
import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.auth.api.facade.UserFacade;
import com.jxph.cloud.service.auth.api.pojo.SysUser;
import com.jxph.cloud.service.auth.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 谢秋豪
 * @date 2018/9/3 21:59
 */
@Api("用户接口")
@RestController
public class UserController implements UserFacade {
    @Autowired
    private UserService userSerice;

    @Override
    @ApiOperation("获取某个用户")
    @Login
    public ResponseResult<String> getUser(@PathVariable(name="id") Long userId, @RequestHeader("token") String token) {
        SysUser sysUser = userSerice.getUserByUserId(userId);
        return ResponseResult.ok(sysUser);
    }

    @Override
    @ApiOperation("新增用户")
    public ResponseResult<String> addUser(@RequestBody @Valid SysUser sysUser) {
        Long id = userSerice.addUser(sysUser);
        return ResponseResult.ok(id);
    }
}
