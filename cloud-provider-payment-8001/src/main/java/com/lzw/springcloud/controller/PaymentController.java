package com.lzw.springcloud.controller;//@date :2022/7/4 22:11


import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("插入结果:" + result + "*******");
        if (result > 0) {
            return new CommonResult(200, "插入成功====serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败====serverPort:" + serverPort, null);
        }
    }

    @GetMapping("getPaymentById/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果:" + result + "*query*");
        if (result != null) {
            return new CommonResult(200, "查询成功====serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "查询失败,没有对应记录" + id + "====serverPort:" + serverPort, null);
        }
    }

    @GetMapping("lb")
    public String getPaymentLb() {
        return serverPort;
    }


    @GetMapping("discovery")
    public Object discovery() {
        //发现服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        log.info("*******************************");

        //得到对应服务名的服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                    + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("feign/timeout")
    public String PaymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("zipkin")
    public String paymentZipkin() {
        return "Zipkin";
    }
}
