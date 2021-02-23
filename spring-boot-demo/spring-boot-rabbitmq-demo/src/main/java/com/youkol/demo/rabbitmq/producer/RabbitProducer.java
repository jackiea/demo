package com.youkol.demo.rabbitmq.producer;

import java.time.LocalDateTime;
import java.util.UUID;

import com.youkol.demo.rabbitmq.config.RabbitConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitProducer {
    
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static final String DATA_FORMAT = "{msgId: %s, content: %s, time: %s, type: %s}";

    public void sendDemoQueue() {
        log.debug("------------ [普通队列模式] 模拟消息投递/生产者");

        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        LocalDateTime time = LocalDateTime.now();
        String message = String.format(DATA_FORMAT, 
                msgId, RabbitConfig.DEMO_QUEUE_NAME, time.toString(), "Demo");

        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_QUEUE_NAME, message);

        log.debug("------------ [普通队列模式] 模拟消息投递/生产者 结束, message: {} ", message);
    }

    public void sendFanout() {
        log.debug("------------ [广播模式] 模拟消息投递/生产者");

        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        LocalDateTime time = LocalDateTime.now();
        String message = String.format(DATA_FORMAT, 
                msgId, RabbitConfig.FANOUT_EXCHANGE_NAME, time.toString(), "Fanout");

        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE_NAME, "", message);

        log.debug("------------ [广播模式]  模拟消息投递/生产者 结束, message: {} ", message);
    }

    public void sendTopicAB() {
        log.debug("------------ [Topic模式AB] 模拟消息投递/生产者");

        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        LocalDateTime time = LocalDateTime.now();
        String message = String.format(DATA_FORMAT, 
                msgId, RabbitConfig.TOPIC_EXCHANGE_NAME, time.toString(), "Topic-AB");

        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE_NAME, "topic.routing.msg",  message);

        log.debug("------------ [Topic模式AB]  模拟消息投递/生产者 结束, message: {} ", message);
    }

    public void sendTopicB() {
        log.debug("------------ [Topic模式B] 模拟消息投递/生产者");

        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        LocalDateTime time = LocalDateTime.now();
        String message = String.format(DATA_FORMAT, 
                msgId, RabbitConfig.TOPIC_EXCHANGE_NAME, time.toString(), "Topic-B");

        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE_NAME, "topic.routing.good.msg", message);

        log.debug("------------ [Topic模式B]  模拟消息投递/生产者 结束, message: {} ", message);
    }

    public void sendTopicBC() {
        log.debug("------------ [Topic模式BC] 模拟消息投递/生产者");

        String msgId = UUID.randomUUID().toString();
        msgId = msgId.replaceAll("-*", "");

        LocalDateTime time = LocalDateTime.now();
        String message = String.format(DATA_FORMAT, 
                msgId, RabbitConfig.DEMO_QUEUE_NAME, time.toString(), "Topic-BC");

        rabbitTemplate.convertAndSend(RabbitConfig.DEMO_QUEUE_NAME, "topic.routing.m.z", message);

        log.debug("------------ [Topic模式BC]  模拟消息投递/生产者 结束, message: {} ", message);
    }

    
}
