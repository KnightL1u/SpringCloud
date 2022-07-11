package com.lzw.springcloud.controller;//@date :2022/7/6 22:10

import com.lzw.springcloud.service.OrderFHService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderFHController {
    @Autowired
    private OrderFHService paymentFHService;

    @GetMapping("ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String s = paymentFHService.paymentInfo_OK(id);
        log.info(s);
        return s;
    }

    //改接口出错后执行的方法
/*    @HystrixCommand(fallbackMethod = "timeoutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })*/
    @GetMapping("timeout/{id}")
    @HystrixCommand    //没有指定的fallback使用默认的
    public String timeout(@PathVariable("id") Integer id) {
        String s = paymentFHService.paymentInfo_TimeOut(id);
        log.info(s);
        return s;
    }

    public String timeoutFallBack(@PathVariable("id") Integer id) {
        return "消费者端口80,服务异常,请稍后再试,id: " + id;
    }
    //全局备选方法
    public String globalFallback() {
        return "服务异常,请稍后再试!Global Fallback";
    }


}
