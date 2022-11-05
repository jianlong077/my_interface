package com.haichao.annotations.idorcode.code;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InCode {
    String code() default "code";
}
