package com.lzw.springcloud.controller;//@date :2022/7/6 9:08

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("consul")
    public String paymentConsul() {
        return "SpringCloud with Consul :" + serverPort + "\t" + UUID.randomUUID();
    }
}
