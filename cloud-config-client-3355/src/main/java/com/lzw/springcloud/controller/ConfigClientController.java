package com.lzw.springcloud.controller;//@date :2022/7/8 17:40

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${config.info}")     //去config-center去拿取配置信息
    public String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
