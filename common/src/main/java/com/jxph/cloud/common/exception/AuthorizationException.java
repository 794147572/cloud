package com.jxph.cloud.common.exception;

/**
 * @author 谢秋豪
 * @date 2018/8/18 23:37
 */
public class AuthorizationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 0401;

    public AuthorizationException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AuthorizationException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AuthorizationException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AuthorizationException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}

