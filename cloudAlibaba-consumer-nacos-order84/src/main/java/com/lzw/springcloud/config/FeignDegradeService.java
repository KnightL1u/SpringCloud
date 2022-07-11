package com.lzw.springcloud.config;//@date :2022/7/10 19:44

import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.CircleBreakerService;
import org.springframework.stereotype.Component;

@Component
public class FeignDegradeService implements CircleBreakerService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(44444, "该服务故障异常,以降级,请稍后再试");
    }
}
