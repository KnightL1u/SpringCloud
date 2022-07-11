package com.lzw.springcloud.controller;//@date :2022/7/5 20:28


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("zk")
    public String paymentZK() {
        return "SpringCloud with ZooKeeper:" + serverPort + "\t" + UUID.randomUUID();
    }
}
