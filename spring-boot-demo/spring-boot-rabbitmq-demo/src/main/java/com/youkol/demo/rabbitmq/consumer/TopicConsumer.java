package com.youkol.demo.rabbitmq.consumer;

import com.youkol.demo.rabbitmq.config.RabbitConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TopicConsumer {
    
    private static final String MSG_FORMAT = "[{}] received message: {}";
    
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_A_NAME)
    public void receiveA(String msg) {
        log.debug(MSG_FORMAT, RabbitConfig.TOPIC_QUEUE_A_NAME, msg);
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_B_NAME)
    public void receiveB(String msg) {
        log.debug(MSG_FORMAT, RabbitConfig.TOPIC_QUEUE_B_NAME, msg);
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_C_NAME)
    public void receiveC(String msg) {
        log.debug(MSG_FORMAT, RabbitConfig.TOPIC_QUEUE_C_NAME, msg);
    }
}
