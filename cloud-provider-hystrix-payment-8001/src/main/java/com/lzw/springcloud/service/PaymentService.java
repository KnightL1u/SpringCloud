package com.lzw.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
