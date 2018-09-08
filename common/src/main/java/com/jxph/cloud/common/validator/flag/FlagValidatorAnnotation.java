package com.jxph.cloud.common.validator.flag;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author 谢秋豪
 * @date 2018/9/1 15:38
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FlagValidator.class)
@Documented
public @interface FlagValidatorAnnotation {
    String values();

    String message() default "状态不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
