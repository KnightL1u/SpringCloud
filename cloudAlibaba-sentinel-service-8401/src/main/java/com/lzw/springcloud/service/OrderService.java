package com.lzw.springcloud.service;//@date :2022/7/10 13:52


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @SentinelResource("goods")
    public String query(){
        return "AAAAAA";
    }
}
