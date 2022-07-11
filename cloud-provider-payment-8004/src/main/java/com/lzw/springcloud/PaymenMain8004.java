package com.lzw.springcloud;//@date :2022/7/5 20:26

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient    //注册服务
public class PaymenMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenMain8004.class);
    }
}
