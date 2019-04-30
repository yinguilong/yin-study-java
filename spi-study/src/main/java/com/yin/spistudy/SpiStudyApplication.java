package com.yin.spistudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

@SpringBootApplication
public class SpiStudyApplication {

    public static void main(String[] args) {
        TreeSet<String> set=new TreeSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("cd");
        set.add("ce");
//        HashMap
//        Suboject realSubject = new RealSubject();
//        InvocationHandler handler = new DynamicProxy(realSubject);
//        Suboject suboject = (Suboject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),
//                handler);
//        System.out.println(suboject.getClass().getName());
//        suboject.doSome();
//
//        SpringApplication.run(SpiStudyApplication.class, args);
        Pointobject pointobject = new Pointobject();
        Test(pointobject);
        System.out.printf(pointobject.getName());
    }

    public static void Test(Pointobject pointobject) {
        pointobject.setName("B");
        pointobject = new Pointobject();
        pointobject.setName("C");
    }
}

