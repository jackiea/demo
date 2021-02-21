package com.youkol.demo.java.nashorn;

import com.youkol.demo.java.nashorn.demo.SimpleDemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaNashornDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaNashornDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            SimpleDemo demo = new SimpleDemo();

            demo.helloWord();

            demo.invokeJsFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
