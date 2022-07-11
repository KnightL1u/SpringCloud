package com.lzw.springcloud.service.Impl;//@date :2022/7/9 9:53

import com.lzw.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;


@EnableBinding(Source.class)   //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;   //通过output向配置的studyExchange交换机  发送消息

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("+++++++Serial+" + serial);
        return null;
    }
}
