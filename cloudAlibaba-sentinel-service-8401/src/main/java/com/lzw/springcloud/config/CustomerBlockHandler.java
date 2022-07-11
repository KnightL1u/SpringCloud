package com.lzw.springcloud.config;//@date :2022/7/10 16:07


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(444, "Global Exception Handler - 01", new Payment(9999L, "serial002"));
    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(555, "Global Exception Handler - 02", new Payment(9999L, "serial002"));
    }
}
