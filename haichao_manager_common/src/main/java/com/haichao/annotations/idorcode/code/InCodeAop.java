package com.haichao.annotations.idorcode.code;

import com.haichao.annotations.param.Body;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author hans
 * @Date 2019/8/15 15:22
 * @Version 1.0
 */

public abstract class InCodeAop {
    @Pointcut("@annotation(inCode)")
    public void pointCut(InCode inCode){}

    @Before("pointCut(inCode)")
    public void Before(JoinPoint joinPoint, InCode inCode)  {
        Annotation[][] params = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations();
        Object obj=null;
        Object[] args=joinPoint.getArgs();
        for (int i = 0 ; i < params.length ; i++) {
            Annotation[] an = params[i];
            boolean flag=false;
            for (Annotation innerAn : an) {
                if(null != args[i]) {
                    if (innerAn instanceof Body) {
                        obj = args[i];
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        if(null !=obj){

            Field name = ReflectionUtils.findField(obj.getClass(),inCode.code());
            name.setAccessible(true);
            if(null == ReflectionUtils.getField(name,obj)) {
                ReflectionUtils.setField(name, obj, setCode(obj.getClass().getSuperclass().getSimpleName()));
            }
            name.setAccessible(false);
        }
    }
    public abstract String setCode(String entityName);
}
