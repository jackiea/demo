package com.youkol.demo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列参考资料:
 * <ul>
 * <li> <a href="https://www.cnblogs.com/xifengxiaoma/p/11121355.html">Spring Boot：使用Rabbit MQ消息队列</a>
 * <li> <a href="https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-amqp">spring-boot-reference</a>
 * <li> <a href="https://www.jianshu.com/p/36a7775b04ec">新手也能看懂，消息队列其实很简单</a>
 * <li> <a href="https://www.jianshu.com/p/dca01aad6bc8">springboot + rabbitmq发送邮件(保证消息100%投递成功并被消费)</a>
 * </ul>
 * 
 * @author jackiea
 */
@Configuration
public class RabbitConfig {
    
    public static final String MAIL_QUEUE_NAME = "mail.queue";
    public static final String MAIL_EXCHANGE_NAME = "mail.exchange";
    public static final String MAIL_ROUTING_KEY_NAME = "mail.routing.key";

    @Bean
    public Queue mailQueue() {
        return new Queue(MAIL_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange mailExchange() {
        return new DirectExchange(MAIL_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(mailQueue())
                .to(mailExchange())
                .with(MAIL_ROUTING_KEY_NAME);
    }
}
