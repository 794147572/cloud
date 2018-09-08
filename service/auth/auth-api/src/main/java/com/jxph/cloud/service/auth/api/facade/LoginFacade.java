package com.jxph.cloud.service.auth.api.facade;


import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.auth.api.form.LoginForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author 谢秋豪
 * @date 2018/9/2 11:10
 */
@RequestMapping("/sessions")
public interface LoginFacade {
    /**
     * @LoginForm
     * @ResponseResult
     */
    @PostMapping()
    ResponseResult<String> login(@Valid @RequestBody LoginForm loginForm, HttpServletResponse response);

}
