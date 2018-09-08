package com.jxph.cloud.service.auth.api.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author 谢秋豪
 * @date 2018/9/1 15:27
 */
@ApiModel(value = "登录表单")
public class LoginForm {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message="手机号不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
