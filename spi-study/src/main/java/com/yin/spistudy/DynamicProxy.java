package com.yin.spistudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/1/28 14:09
 **/
public class DynamicProxy implements InvocationHandler {

    private Suboject subject;
    public  DynamicProxy(Suboject subject){
        this.subject=subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before do");
        System.out.println("Method:"+method);
        method.invoke(subject,args);
        System.out.println("after do");
        return null;
    }
}
