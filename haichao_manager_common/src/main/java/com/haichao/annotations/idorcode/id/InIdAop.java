package com.haichao.annotations.idorcode.id;

import com.haichao.annotations.idorcode.IdCode;
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

public  class InIdAop {
    @Pointcut("@annotation(inId)")
    public void pointCut(InId inId){}

    @Before("pointCut(inId)")
    public void Before(JoinPoint joinPoint, InId inId)  {
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
            Field name = ReflectionUtils.findField(obj.getClass(),inId.id());
            name.setAccessible(true);
            ReflectionUtils.setField(name,obj, IdCode.id());
            name.setAccessible(false);
        }
    }
}
