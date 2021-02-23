package com.youkol.demo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

    // ============= 普通队列模式 =============

    public static final String DEMO_QUEUE_NAME = "demo.queue";

    @Bean
    public Queue demoQueue() {
        return new Queue(DEMO_QUEUE_NAME);
    }

    // ============= fanout广播模式 =============

    public static final String FANOUT_QUEUE_A_NAME = "fanout.queue.a";
    public static final String FANOUT_QUEUE_B_NAME = "fanout.queue.b";
    public static final String FANOUT_QUEUE_C_NAME = "fanout.queue.c";
    public static final String FANOUT_EXCHANGE_NAME = "fanout.exchange";

    @Bean
    public Queue fanoutAQueue() {
        return new Queue(FANOUT_QUEUE_A_NAME);
    }

    @Bean
    public Queue fanoutBQueue() {
        return new Queue(FANOUT_QUEUE_B_NAME);
    }

    @Bean
    public Queue fanoutCQueue() {
        return new Queue(FANOUT_QUEUE_C_NAME);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingExchangeWithA() {
        return BindingBuilder.bind(fanoutAQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(fanoutBQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(fanoutCQueue()).to(fanoutExchange());
    }

    // ============= topic广播模式 =============

    public static final String TOPIC_QUEUE_A_NAME = "topic.queue.a";
    public static final String TOPIC_QUEUE_B_NAME = "topic.queue.b";
    public static final String TOPIC_QUEUE_C_NAME = "topic.queue.c";
    public static final String TOPIC_EXCHANGE_NAME = "topic.exchange";

    @Bean
    public Queue topicAQueue() {
        return new Queue(TOPIC_QUEUE_A_NAME);
    }

    @Bean
    public Queue topicBQueue() {
        return new Queue(TOPIC_QUEUE_B_NAME);
    }

    @Bean
    public Queue topicCQueue() {
        return new Queue(TOPIC_QUEUE_C_NAME);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingTopicExchangeWithA() {
        return BindingBuilder.bind(topicAQueue()).to(topicExchange()).with("topic.routing.msg");
    }

    @Bean
    public Binding bindingTopicExchangeWithB() {
        return BindingBuilder.bind(topicBQueue()).to(topicExchange()).with("topic.routing.#");
    }

    @Bean
    public Binding bindingTopicExchangeWithC() {
        return BindingBuilder.bind(topicCQueue()).to(topicExchange()).with("topic.routing.*.z");
    }
}
