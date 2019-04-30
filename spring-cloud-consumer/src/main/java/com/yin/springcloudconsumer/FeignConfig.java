package com.yin.springcloudconsumer;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * feign配置类
 *
 * @author yinguilong
 * @Time 2019/4/30 10:51
 **/
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
