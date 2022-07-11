package com.lzw.springcloud.service;


import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //到哪一个微服务里面去找方法
public interface PaymentFeignService {

    @GetMapping(value = "payment/getPaymentById/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping(value = "payment/feign/timeout")
        //接口全路径
    String PaymentFeignTimeOut();
}
