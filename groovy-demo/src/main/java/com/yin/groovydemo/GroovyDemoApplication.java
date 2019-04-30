package com.yin.groovydemo;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class GroovyDemoApplication {

    public static void main(String[] args) {
        try {
            boolean a = TestEnum.NO == TestEnum.NO;
            GroovyClassLoader loader = new GroovyClassLoader();
            java.net.URL uri= Thread.currentThread().getClass().getResource("/TestGroovy.groovy");
            GroovyCodeSource codeSource=new GroovyCodeSource(uri);
            Class l = loader.parseClass(codeSource);
            GroovyObject groovyObject = (GroovyObject) l.newInstance();
            Ce c = new Ce();
            c.setName("yin");
            groovyObject.invokeMethod("hello", null);
//           GroovyScriptEngine engine=new GroovyScriptEngine(new String[]{"ss"});
        } catch (Exception e) {
            System.out.println(e);
        }
        SpringApplication.run(GroovyDemoApplication.class, args);
    }

}
