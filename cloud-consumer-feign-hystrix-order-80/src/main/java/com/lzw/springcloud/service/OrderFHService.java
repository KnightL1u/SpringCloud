package com.lzw.springcloud.service;


import com.lzw.springcloud.service.Impl.OrderFHServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",     //指定微服务名
        fallback = OrderFHServiceImpl.class)   //服务方法的fallback方法
public interface OrderFHService {

    @GetMapping("payment/hystrix/ok/{id}")    //注意是微服务端的请求全路径
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
