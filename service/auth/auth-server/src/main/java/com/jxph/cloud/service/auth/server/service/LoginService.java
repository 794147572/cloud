package com.jxph.cloud.service.auth.server.service;

import com.jxph.cloud.service.auth.api.form.LoginForm;

import javax.validation.Valid; /**
 * @author 谢秋豪
 * @date 2018/9/3 22:20
 */
public interface LoginService {
    String login(LoginForm loginForm);
}
