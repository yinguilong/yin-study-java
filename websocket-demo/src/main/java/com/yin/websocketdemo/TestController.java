package com.yin.websocketdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019-09-10 17:12
 **/
@RestController
public class TestController {
    @RequestMapping("index")
    public String index(String name) {
        return name;
    }
}
