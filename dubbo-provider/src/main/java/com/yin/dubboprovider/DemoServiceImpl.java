package com.yin.dubboprovider;

import  com.yin.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/1/23 18:14
 **/
@Service(interfaceClass = DemoService.class)
@Component
public class DemoServiceImpl implements  DemoService {
    /**
     * ss
     */
    private int i;
    @Override
    public void SayHello() {
        System.out.println("hello yin"+(i++));
    }
}
