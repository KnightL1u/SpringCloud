package com.lzw.springcloud;//@date :2022/7/6 22:02

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFHMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFHMain80.class);
    }
}
