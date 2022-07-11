package com.lzw.LBRule;//@date :2022/7/6 14:00


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
