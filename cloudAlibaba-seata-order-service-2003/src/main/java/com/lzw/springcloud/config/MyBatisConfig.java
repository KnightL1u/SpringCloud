package com.lzw.springcloud.config;//@date :2022/7/10 23:34

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.lzw.springcloud.dao"})
public class MyBatisConfig {

}


