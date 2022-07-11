package com.lzw.springcloud.config;//@date :2022/7/6 9:24


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean           //注入
    @LoadBalanced    //负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
