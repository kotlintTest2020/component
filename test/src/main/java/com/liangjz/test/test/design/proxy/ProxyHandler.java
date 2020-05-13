package com.liangjz.test.test.design.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    private Object mTarget;
    public  Object newProxy(Object target){
        this.mTarget = target;
        return Proxy.newProxyInstance(mTarget.getClass().getClassLoader(),mTarget.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        Object o = method.invoke(mTarget,args);
        return o;
    }
}
