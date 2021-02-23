package com.youkol.demo.rabbitmq;

import java.util.stream.IntStream;

import com.youkol.demo.rabbitmq.producer.MailProducer;
import com.youkol.demo.rabbitmq.producer.RabbitProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitmqDemoApplication implements ApplicationRunner {

    @Autowired
    private MailProducer mailProducer;

    @Autowired
    private RabbitProducer rabbitProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0, 10).forEach(i -> {
            rabbitProducer.sendDemoQueue();
            rabbitProducer.sendFanout();
            rabbitProducer.sendTopicAB();
            rabbitProducer.sendTopicB();
            rabbitProducer.sendTopicBC();

            mailProducer.sendMail();
        });

    }

}
