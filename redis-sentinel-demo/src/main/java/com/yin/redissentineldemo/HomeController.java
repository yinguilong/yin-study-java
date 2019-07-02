package com.yin.redissentineldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/6/23 15:15
 **/
@RestController
public class HomeController {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/")
    public String index(@RequestParam String a) {
        try {
            redisTemplate.opsForValue().set("yin", a);
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }

        return a;
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello y";
    }
}
