package com.youkol.demo.rabbitmq.producer;

import java.util.Random;
import java.util.UUID;

import com.youkol.demo.rabbitmq.config.RabbitConfig;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailProducer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送邮件消息
     * 
     */
    public void sendMail() {
        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        log.debug("**************** 模拟发送邮件消息, msgId: {}.", msgId);
        
        CorrelationData correlationData = new CorrelationData(msgId);
        String message = "This is a test mail. [id: " + new Random().nextInt() + "]";

        log.debug("**************** 模拟发送消息内容： {}", message);

        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, 
                RabbitConfig.MAIL_ROUTING_KEY_NAME, 
                message, correlationData);

        log.debug("**************** 模拟发送邮件消息结束.");
    }
}
