package com.haichao.annotations.permissions;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String codeApi() default "";
    String nameApi() default "";
}
