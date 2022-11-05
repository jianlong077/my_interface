package com.haichao.annotations.idorcode.id;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InId {
    String id() default "cguid";
}
