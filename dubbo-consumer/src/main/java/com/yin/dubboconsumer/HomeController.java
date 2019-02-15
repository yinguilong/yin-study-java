package com.yin.dubboconsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yin.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/1/23 18:26
 **/
@RestController
public class HomeController {
    /**
     * shili
     */
    @Reference()
    private DemoService demoservice;

    @RequestMapping("/")
    public String hello() {
        demoservice.SayHello();
        return "haha";
    }

}
