package com.oasis.springboot.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class Course{
    public void find() {
        System.out.println("test find");
    }
    public void save() {
        System.out.println("test save");
    }
}

class CglibProxy implements MethodInterceptor {
    Object target;

    public Object getProxyInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before***************");
        Object result = methodProxy.invokeSuper(target,args);
        System.out.println("After***************");
        return result;
    }
}

public class CglibDynamicProxy {
    public static void main(String[] args) {
        Course course = (Course) new CglibProxy().getProxyInstance(new Course());
        course.find();
        course.save();
    }
}
