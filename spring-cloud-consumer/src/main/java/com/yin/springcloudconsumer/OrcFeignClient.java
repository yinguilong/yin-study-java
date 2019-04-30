package com.yin.springcloudconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 封装对具体服务实现的条用
 *
 * @author yinguilong
 * @Time 2019/4/30 10:53
 **/
@FeignClient(value = "orc-service", configuration = FeignConfig.class)
public interface OrcFeignClient {

    @GetMapping("/home/hello")
    String hello();
}
