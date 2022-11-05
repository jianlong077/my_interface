package com.haichao.annotations.reids;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Redis {
    String name() default "缓存";
    ReidsEnum val();
    //锁时间:秒
    long expire() default 60L;
}