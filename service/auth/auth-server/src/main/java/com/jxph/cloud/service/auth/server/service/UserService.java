package com.jxph.cloud.service.auth.server.service;

import com.jxph.cloud.service.auth.api.pojo.SysUser; /**
 * @author 谢秋豪
 * @date 2018/9/3 22:05
 */
public interface UserService {
    Long addUser(SysUser sysUser);

    SysUser getUserByUserId(Long userId);
}
