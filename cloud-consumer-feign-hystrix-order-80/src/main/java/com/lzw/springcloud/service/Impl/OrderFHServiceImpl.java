package com.lzw.springcloud.service.Impl;//@date :2022/7/7 14:31

import com.lzw.springcloud.service.OrderFHService;
import org.springframework.stereotype.Component;


@Component     //当远程调用接口的方法出错时,,,fallback这里的方法
public class OrderFHServiceImpl implements OrderFHService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut";
    }
}
