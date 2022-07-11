package com.lzw.springcloud.controller;//@date :2022/7/10 8:22

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lzw.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("getA")
    public String getA() {
        return "TestA";
    }

    @GetMapping("getB")
    public String getB() {
        return "TestB";
    }

    @GetMapping("getD")
    public String getD() {
        log.info("测试慢调用比例" + Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TestD";
    }

    @GetMapping("getE")
    public String getE() {
        log.info("异常比例测试" + Thread.currentThread().getName());
        int age = 10 / 0;
        return "TestE";
    }

    @GetMapping("getF")
    public String getF() {
        log.info("异常数测试" + Thread.currentThread().getName());
        int age = 10 / 0;
        return "TestF";
    }


    //如果hotkey这个资源的访问超出了  对应的阈值,,那么就启用deal_hotkey作为备选方法执行
    //如果没有指定  blockHandler   那么就会报500 Error页面
    @GetMapping("hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "deal_hotkey")
    public String TestHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "test hotkey";
    }


    public String deal_hotkey(String p1, String p2, BlockException exception) {
        return "deal_hotkey,o(╥﹏╥)o ";
    }


    @Resource
    private OrderService orderService;

    @GetMapping("query")
    public String query() {
        return orderService.query();
    }

    @GetMapping("save")
    public String save() {
        return orderService.query();
    }

}
