package com.lzw.springcloud.controller;//@date :2022/7/10 8:22

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lzw.springcloud.config.CustomerBlockHandler;
import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class RatioController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    //AA
    @GetMapping("/ratio/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2021L, "serial002"));
    }

    @GetMapping("/ratio/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")     //自定义的处理类
    public CommonResult customerBlockHandler() {    //采用哪一个方法进行执行
        return new CommonResult(200, "客户自定义", new Payment(8888L, "serial002"));
    }


}
