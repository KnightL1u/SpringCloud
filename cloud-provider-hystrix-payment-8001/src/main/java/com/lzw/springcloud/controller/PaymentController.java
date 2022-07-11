package com.lzw.springcloud.controller;//@date :2022/7/6 21:04


import com.lzw.springcloud.PaymentHystrixMain8001;
import com.lzw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_OK(id);
        log.info("=====result:" + s);
        return s;
    }

    @GetMapping("hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_TimeOut(id);
        log.info("=====result:" + s);
        return s;
    }



    /*服务熔断*/

    //===服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }


}
