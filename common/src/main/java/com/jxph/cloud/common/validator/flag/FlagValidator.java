package com.jxph.cloud.common.validator.flag;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 谢秋豪
 * @date 2018/9/1 16:02
 */
public class FlagValidator implements ConstraintValidator<FlagValidatorAnnotation,String> {
    private String values;

    @Override
    public void initialize(FlagValidatorAnnotation constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        String[] str = values.split(",");
        boolean flag = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(values)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
