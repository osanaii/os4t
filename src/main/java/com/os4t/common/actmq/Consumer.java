package com.os4t.common.actmq;

import com.os4t.modules.sms.entity.Email;
import com.os4t.modules.sms.service.SmsService;
import com.os4t.modules.sms.service.impl.SmsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private SmsService smsService;

    @JmsListener(destination = "os4t")
    public void receive(Email message) {
        try{
            smsService.send(message);
        } catch (Exception e){
            logger.error("${0}邮件消息发送失败",message.getSubject());
        }
        System.out.println("收到的 message 是：" + message.toString());
    }

}
