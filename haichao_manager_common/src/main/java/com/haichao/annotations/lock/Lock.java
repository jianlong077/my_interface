package com.haichao.annotations.lock;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {
    //被锁的数据的id
    String name() default "加锁";

    //锁时间:秒
    long expire() default 60L;

    //等待时间:秒
    long waitTime() default 1L;
}