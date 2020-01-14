package com.oasis.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(public * com.oasis.springboot.action..*.*(..))")
    public void logPointCut(){}

    @Before(value = "logPointCut()")
    public void doBefore(JoinPoint joinPoint){
        //获取url、IP、port
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //javax.servlet.http.HttpServletRequest,不要错选Tomcat中的同名类
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("url:{}",request.getRequestURL());
        log.info("host-ip:{}",request.getRemoteHost()+"***"+request.getRemoteAddr());
        log.info("port:{}",request.getRemotePort());
        //获取执行了哪个Action的什么方法，输入了什么参数
        log.info("*************************************************************");
        log.info("class:{}",joinPoint.getTarget().getClass().getName());
        log.info("type:{}",joinPoint.getSignature().getDeclaringType());
        log.info("method:{}",joinPoint.getSignature().getName());
        log.info("args:{}",Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "logPointCut()")
    public void doAfter(){
        log.info("do after  .......");
    }

    @AfterReturning(value = "logPointCut()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,Object result){
        log.info("after returning , result is : {}",result);
    }

    //通过@Around检测Action执行时间，进而监控执行效率
    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long start  = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long end  = System.currentTimeMillis();
        log.info("*******cost time*******:{}ms",end-start);
        return obj;
    }

    @AfterThrowing(value = "logPointCut()",throwing = "e")
    public void doThrowing(JoinPoint joinPoint,Exception e){
        log.info("throwing:{}",e);
    }
}
