package com.jxph.cloud.service.fast.api.form;

import com.jxph.cloud.common.validator.flag.FlagValidatorAnnotation;

/**
 * @author 谢秋豪
 * @date 2018/9/1 16:08
 */
public class TestForm {
    @FlagValidatorAnnotation(values = "1,2,3")
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
