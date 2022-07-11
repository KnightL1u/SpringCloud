package com.lzw.springcloud.controller;//@date :2022/7/6 15:41

import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

    @GetMapping("payment/timeout")
    public String PaymentFeignTimeOut() {
        return paymentFeignService.PaymentFeignTimeOut();
    }
}
