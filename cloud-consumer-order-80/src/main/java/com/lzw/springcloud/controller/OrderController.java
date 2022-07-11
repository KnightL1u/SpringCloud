package com.lzw.springcloud.controller;//@date :2022/7/5 9:01


import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
//找到Eureka里面的对应服务,有多个就会进行负载均衡   对外暴露的是微服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumercreate");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("consumergetPaymentById");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("zipkin")
    public String getPaymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
    }

}
