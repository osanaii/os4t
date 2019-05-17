package com.os4t.common.actmq;

import com.os4t.modules.sms.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Email message) {
        jmsTemplate.convertAndSend("os4t", message);
    }
}