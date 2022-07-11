package com.lzw.springcloud;//@date :2022/7/9 14:02

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CAPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(CAPaymentMain9001.class);
    }
}
