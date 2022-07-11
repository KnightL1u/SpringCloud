package com.lzw.springcloud.controller;//@date :2022/7/9 10:03

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String servePort;


    @StreamListener(Sink.INPUT)  //监听配置的studyExchange交换机发送的消息
    public void input(Message<String> message) {
        System.out.println("消费者2号,收到消息-->" + message.getPayload() + "\t serverPort: " + servePort);
    }

}
