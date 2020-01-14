package com.oasis.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    Logger log = LoggerFactory.getLogger(UserAspect.class);
    @Pointcut(value = "execution(public * com.oasis.springboot.action.OasisAction.*(..))")
    public void pointCut(){}


    @Before(value = "pointCut()")
    public void doBeforeOasisAction(){
        log.debug("before OasisAction execute....................");
    }
    @After(value = "pointCut()")
    public void doAfterOasisAction(){
        log.debug("after OasisAction execute....................");

    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturningOasisAction(JoinPoint joinPoint,Object result){
        log.debug("********************* after returning,result is :"+result);
    }
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void doAfterThrowingOasisAction(JoinPoint joinPoint,Exception e)throws Exception{
        log.debug("********************* afeter throwing,exception: "+e);
    }

    @Around(value = "pointCut()")
    public Object doAroundOasisAction(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("$$$$$$$$around 前置信息");
        Object obj = pjp.proceed();
        log.debug("$$$$$$$$around 后置信息");
        return obj;
    }
}
