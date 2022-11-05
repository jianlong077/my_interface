package com.haichao.annotations.reids;

import com.haichao.annotations.param.RedisKey;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author hans
 * @Date 2019/8/15 15:22
 * @Version 1.0
 */

public abstract class RedisAop {
    Logger logger = LoggerFactory.getLogger(RedisAop.class);
    @Pointcut("@annotation(redis)")
    public void redisPoint(Redis redis){}

    @Around("redisPoint(redis)")
    public Object around(ProceedingJoinPoint joinPoint, Redis redis) throws Throwable {
        String key="";
        Annotation[][] params = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations();
        Object[] args=joinPoint.getArgs();
        for (int i = 0 ; i < params.length ; i++) {
            Annotation[] an = params[i];
            boolean flag=false;
            for (Annotation innerAn : an) {
                if(innerAn instanceof RedisKey){
                    if(null != innerAn) {
                        if(null !=args[i]) {
                            key = redis.name()+"|" + args[i].toString() + "|";
                            flag=true;
                            break;
                        }
                    }
                }
            }
            if(flag){
                break;
            }
        }
        if(StringUtils.isNotBlank(key)) {
            if (redis.val() == ReidsEnum.ADD) {
                delte(key);
            } else if (redis.val() == ReidsEnum.UPDATE) {
                delte(key);
            } else if (redis.val() == ReidsEnum.DELETE) {
                delte(key);
            } else if (redis.val() == ReidsEnum.FIND) {
                Object obj = find(key);
                if (obj == null) {
                    obj = joinPoint.proceed();
                    /*if(obj instanceof BaseJsonVo) {
                        BaseJsonVo baseJsonVo= (BaseJsonVo)obj;
                        if(baseJsonVo.getStatus() ==200) {
                            save(key, obj, redis.expire());
                        }
                    }else{
                        obj = joinPoint.proceed();
                        save(key, obj, redis.expire());
                    }*/
                }
                return obj;
            }
        }
        return joinPoint.proceed();
    }

    public abstract void save(String key, Object value, long expire);
    public abstract void delte(String key);
    public abstract Object find(String key);

}
