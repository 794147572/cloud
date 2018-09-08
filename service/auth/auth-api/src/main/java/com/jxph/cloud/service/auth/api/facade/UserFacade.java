package com.jxph.cloud.service.auth.api.facade;


import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.auth.api.pojo.SysUser;
import org.springframework.web.bind.annotation.*;

/**
 * @author 谢秋豪
 * @date 2018/9/2 11:13
 */
@RequestMapping("/users")
public interface UserFacade {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    ResponseResult<String> getUser(@PathVariable(name="id") Long userId, @RequestHeader("token") String token);

    @PostMapping(value = "")
    ResponseResult<String> addUser(@RequestBody SysUser sysUser);
}
