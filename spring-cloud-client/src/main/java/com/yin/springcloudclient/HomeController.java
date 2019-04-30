package com.yin.springcloudclient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/4/30 10:12
 **/
@RestController
@RequestMapping("home")
public class HomeController {

    @RequestMapping("hello")
    public String hello() {
        return "hello keny";
    }
}
