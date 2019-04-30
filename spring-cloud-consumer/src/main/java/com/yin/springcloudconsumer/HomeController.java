package com.yin.springcloudconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者
 *
 * @author yinguilong
 * @Time 2019/4/30 10:58
 **/
@RestController
public class HomeController {

    @Autowired
    private OrcFeignClient orcFeignClient;

    @RequestMapping("sayHello")
    public String sayHello() {
        return orcFeignClient.hello();
    }
}
