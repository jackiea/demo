package com.youkol.demo.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import com.youkol.demo.rabbitmq.config.RabbitConfig;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jackiea
 */
@Component
@Slf4j
public class MailListener {

    @RabbitListener(queues = RabbitConfig.MAIL_QUEUE_NAME)
    public void mailConsume(Message message, Channel channel) {
        log.debug("============== 收到消息： {}", message);

        // 模拟发送邮件
        try {
            Thread.sleep(10 * 1000L);
        } catch (InterruptedException ex) {
            log.error("模拟发送邮件出现异常", ex);
            Thread.currentThread().interrupt();
        }

        log.debug("============== 消息处理完成。");
    }
}
