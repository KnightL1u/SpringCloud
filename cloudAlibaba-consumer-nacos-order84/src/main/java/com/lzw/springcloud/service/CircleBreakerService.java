package com.lzw.springcloud.service;//@date :2022/7/10 16:47


import com.lzw.springcloud.config.FeignDegradeService;
import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component                                  //为FeignClient设置接口的方法的fallback方法
@FeignClient(value = "nacos-payment-provider", fallback = FeignDegradeService.class)
public interface CircleBreakerService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
