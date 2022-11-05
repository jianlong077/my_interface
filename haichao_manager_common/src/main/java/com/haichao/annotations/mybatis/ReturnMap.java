package com.haichao.annotations.mybatis;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnMap {
    String key() default "code";
}
