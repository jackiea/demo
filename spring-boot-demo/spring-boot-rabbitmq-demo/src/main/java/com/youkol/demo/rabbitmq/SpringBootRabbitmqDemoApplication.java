package com.youkol.demo.rabbitmq;

import java.util.stream.IntStream;

import com.youkol.demo.rabbitmq.producer.MailProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitmqDemoApplication implements ApplicationRunner {

    @Autowired
    private MailProducer mailProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0, 10).forEach(i -> mailProducer.sendMail());

    }

}
