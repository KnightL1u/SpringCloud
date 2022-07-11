package com.lzw.springcloud.config;//@date :2022/7/5 9:05


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean   //注入RestTemplate
    @LoadBalanced    //实现负载均衡    (轮询)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
