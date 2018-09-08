package com.jxph.cloud.service.auth.api.common.enums;

/**
 * @author 谢秋豪
 * @date 2018/9/3 22:43
 */
public enum SysUserStatusEnums {
    DISABLE((byte)1),
    NORMAL((byte)0);

    private Byte status;

    SysUserStatusEnums(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }
}
