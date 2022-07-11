package com.lzw.springcloud.service.Impl;//@date :2022/7/6 20:56

import cn.hutool.core.util.IdUtil;
import com.lzw.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池+" + Thread.currentThread().getName() +
                "  paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }


    //启用Hystrix    当时服务持续时间超过设定时间和服务抛出异常时 ,就会执行fallback方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")  //设置超时有效时间
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //int age = 10 / 0;    //直接报错
        int nums = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(nums);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池+" + Thread.currentThread().getName() +
                "  paymentInfo_TimeOut,id:" + id + "   ┭┮﹏┭┮   耗时(Seconds)" + nums;
    }

    public String paymentInfo_TimeOut_handler(Integer id) {
        return "系统繁忙,请稍后再试!";
    }


    /*==服务熔断==*/

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }


}
