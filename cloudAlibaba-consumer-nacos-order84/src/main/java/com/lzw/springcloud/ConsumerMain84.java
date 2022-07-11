package com.lzw.springcloud;//@date :2022/7/10 16:37
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMain84
{
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain84.class, args);
    }
}

