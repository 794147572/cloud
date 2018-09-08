package com.jxph.cloud.common.exception;

import com.jxph.cloud.common.enums.ResultCodeEnum;

/**
 * @author 谢秋豪
 * @date 2018/9/3 22:23
 */
public class UserInvalidException extends BaseException {

    private String msg;
    private int code = ResultCodeEnum.DATA_IS_WRONG.getCode();

    public UserInvalidException(String msg) {
        super(msg);
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }
}
