package com.haichao.annotations.log;

import java.lang.annotation.*;

/**
 * 、ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中；
 *
 * 2、ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中（例如声明语句、泛型和强制转换语句中的类型）;
 */
@Documented
@Target(value = {ElementType.METHOD})//该注解可以放在方法上，属性上，类上
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethod {
    /**
     * 功能
     */
     String function();

}
