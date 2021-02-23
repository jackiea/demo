package com.youkol.demo.rabbitmq.consumer;

import com.youkol.demo.rabbitmq.config.RabbitConfig;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RabbitListener(queues = RabbitConfig.DEMO_QUEUE_NAME)
public class DemoQueueConsumer {
    
    @RabbitHandler
    public void receive(String msg) {
        log.debug("[demo queue] received message: " + msg);
    }
}
