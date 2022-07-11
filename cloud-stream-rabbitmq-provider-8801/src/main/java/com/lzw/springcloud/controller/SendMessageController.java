package com.lzw.springcloud.controller;//@date :2022/7/9 10:03

import com.lzw.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider iMessageProvider;


    @GetMapping("send")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
