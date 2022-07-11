package com.lzw.springcloud.controller;//@date :2022/7/10 16:39

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.CircleBreakerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    @Resource
    private CircleBreakerService circleBreakerService;

    @RequestMapping("/consumer/fallback/{id}")
    //fallback当服务发生异常是  会执行   handlerFallback方法
    //blockHandler只负责sentinel配置的违规,才会返回配置的blockHandler,,没有违规且爆运行时异常会显示ERROR PAGE
    //exceptionToIgnore   如果爆出了该属性指定的异常,那么会忽略掉这个异常不执行fallback方法,直接返回ERROR PAGE
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = circleBreakerService.paymentSQL(id);
        if (id == 4)
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        else if (result.getData() == null)
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        return result;
    }

    //fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }

    @GetMapping("/query/{id}")
    public CommonResult<Payment> query(@PathVariable("id") Long id) {
        return circleBreakerService.paymentSQL(id);
    }
}