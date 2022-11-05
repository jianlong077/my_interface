package com.haichao.annotations.lock;

import com.haichao.annotations.param.RedisKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;

/**
 * @Description:
 * @Author hans
 * @Date 2019/8/15 15:22
 * @Version 1.0
 */

public abstract class LockAop extends RedisLock {
    Logger logger = LoggerFactory.getLogger(LockAop.class);
    @Pointcut("@annotation(lock)")
    public void lockPoint(Lock lock){}

    @Around("lockPoint(lock)")
    public Object around(ProceedingJoinPoint joinPoint, Lock lock) throws Throwable {
        StringBuffer key=new StringBuffer();
        key.append(lock.name()).append("|");

        Annotation[][] params = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations();
        Object[] args=joinPoint.getArgs();
        for (int i = 0 ; i < params.length ; i++) {
            Annotation[] an = params[i];
            for (Annotation innerAn : an) {
                if(null != args[i]) {
                    if (innerAn instanceof RedisKey) {
                        key.append(args[i].toString()).append("|");
                    }
                }
            }
        }
        Long expireTime = lock.expire();
        Long waitTime = lock.waitTime();

        return super.lock(key.toString(),expireTime,waitTime, new MethodCallBack() {
                    @Override
                    public Object method()  {
                        try {
                            return joinPoint.proceed();
                        }catch (Throwable e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }

                    }
                });
    }
}
