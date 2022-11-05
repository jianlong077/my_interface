package com.haichao.annotations.log;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogClass {
    /**
     * 模块
     */
    String module();
    /**
     * 表单
     */
    String table();
}