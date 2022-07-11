package com.lzw.springcloud;//@date :2022/7/8 17:39

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class);
    }
}
