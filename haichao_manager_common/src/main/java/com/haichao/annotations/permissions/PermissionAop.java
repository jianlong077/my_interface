package com.haichao.annotations.permissions;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:
 * @Author hans
 * @Date 2019/8/15 15:22
 * @Version 1.0
 */

public abstract class PermissionAop {
    @Pointcut("@annotation(permission)")
    public void pointCut(Permission permission){}

    //环绕通知
    @Around("pointCut(permission)")
    public Object  around(ProceedingJoinPoint point, Permission permission) throws Throwable {
        Object baseJsonVo=checkCanOperation( permission,point);
        return point.proceed();

    }

    public abstract Object checkCanOperation(Permission permission,ProceedingJoinPoint point);

}
