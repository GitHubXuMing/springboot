package com.oasis.springboot.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface StuDao{
    public void find();
    public void save();
}

class StuDaoImpl implements StuDao{

    @Override
    public void find() {
        System.out.println("test find");
    }

    @Override
    public void save() {
        System.out.println("test save");
    }
}

class JdkProxyFactory{
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        //JDK动态代理--JDK--Proxy
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if(methodName.indexOf("find") != -1){
                            return method.invoke(target,args);
                        }else {
                            System.out.println("jdk dynamic proxy begin transaction~!");
                            Object obj = method.invoke(target, args);
                            System.out.println("commit transaction~!");
                            return obj;
                        }
                    }
                });
        return proxyInstance;
    }
}
public class JdkDynamicProxy {
    public static void main(String[] args) {
        StuDao stuDao = new StuDaoImpl();
        StuDao stuDaoProxy = (StuDao) new JdkProxyFactory(stuDao).getProxyInstance();
        stuDaoProxy.find();
        stuDaoProxy.save();

    }
}
