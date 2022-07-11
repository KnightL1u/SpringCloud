package com.lzw.springcloud.service.impl;//@date :2022/7/4 22:07

import com.lzw.springcloud.dao.PaymentDao;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;


    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
