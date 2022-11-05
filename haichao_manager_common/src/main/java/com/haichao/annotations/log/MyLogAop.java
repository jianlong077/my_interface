package com.haichao.annotations.log;

import com.haichao.annotations.param.Body;
import com.haichao.annotations.param.Code;
import com.haichao.annotations.param.CodeOut;
import com.haichao.annotations.param.Param;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * execution：一般用于指定方法的执行，用的最多。
 * within：指定某些类型的全部方法执行，也可用来指定一个包。
 * this：Spring Aop是基于动态代理的，生成的bean也是一个代理对象，this就是这个代理对象，当这个对象可以转换为指定的类型时，对应的切入点就是它了，Spring Aop将生效。
 * target：当被代理的对象可以转换为指定的类型时，对应的切入点就是它了，Spring Aop将生效。
 * args：当执行的方法的参数是指定类型时生效。
 * @target：当代理的目标对象上拥有指定的注解时生效。
 * @args：当执行的方法参数类型上拥有指定的注解时生效。
 * @within：与@target类似，看官方文档和网上的说法都是@within只需要目标对象的类或者父类上有指定的注解，则@within会生效，而@target则是必须是目标对象的类上有指定的注解。而根据笔者的测试这两者都是只要目标类或父类上有指定的注解即可。
 * @annotation：当执行的方法上拥有指定的注解时生效。
 * reference pointcut：(经常使用)表示引用其他命名切入点，只有@ApectJ风格支持，Schema风格不支持
 * bean：当调用的方法是指定的bean的方法时生效。(Spring AOP自己扩展支持的)
 *
 理解AOP@Before,@After,@AfterReturning,@AfterThrowing执行顺序
 实现AOP的切面主要有以下几个要素：
 使用@Aspect注解将一个java类定义为切面类
 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
 根据需要在切入点不同位置的切入内容
 使用@Before在切入点开始处切入内容
 使用@After在切入点结尾处切入内容
 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 */
public abstract class MyLogAop {
    static Logger logger = LoggerFactory.getLogger(MyLogAop.class);
    //定义切点方法
    @Pointcut("@target(logClass) && @annotation(logMethod)")
    public  void pointLogMethod(LogClass logClass,LogMethod logMethod){}
    //环绕通知
    @Around("pointLogMethod(logClass,logMethod) ")
    public Object  around(ProceedingJoinPoint point,LogClass logClass, LogMethod logMethod) throws Throwable{

            long startTime=System.currentTimeMillis();

            Signature signature = point.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            //1.获取到方法的所有参数名称
            String[] paramNames = methodSignature.getParameterNames();
            //2.获取到所有的参数值的数组
            Object[] paramVlues = point.getArgs();
            Annotation[][] params = ((MethodSignature) point.getSignature()).getMethod().getParameterAnnotations();
            Map<String,Object> param=new HashMap<>();
            String code="";
            for (int i = 0 ; i < params.length ; i++) {
                Annotation[] an = params[i];
                for (Annotation innerAn : an) {
                    if(null != paramVlues[i]) {
                        if (innerAn instanceof Code) {
                            param.put(paramNames[i], paramVlues[i]);
                            code=null != paramVlues[i]?paramVlues[i].toString():null;
                        } else if (innerAn instanceof CodeOut) {
                            param.put(paramNames[i], paramVlues[i]);
                        } else if (innerAn instanceof Param) {
                            param.put(paramNames[i], paramVlues[i]);
                        } else if (innerAn instanceof Body) {
                            param.put(paramNames[i], paramVlues[i]);
                        }
                    }
                }
            }
            Object returnData =null;
                try {
                    returnData = point.proceed();
                }catch (Exception e){
                    logger.error("异常：{}",e);
                }
        save(logClass, logMethod,code,startTime,param,null);
        return returnData;

    }
    @Async
    public abstract void save(LogClass  module,LogMethod table,String code,long startTime,Map<String,Object> param,Object results);
}
