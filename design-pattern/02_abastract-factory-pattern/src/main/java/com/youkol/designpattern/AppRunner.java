package com.youkol.designpattern;

import com.youkol.designpattern.abastractfactory.JavaCourseFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========== Abstract Factory Pattern start ...");

        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNote().edit();
        javaCourseFactory.createVideo().record();
        
        System.out.println("========== Abstract Factory Pattern end ...");

    }
    
}
