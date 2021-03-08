package com.youkol.designpattern;

import com.youkol.designpattern.factorymethod.ICourse;
import com.youkol.designpattern.factorymethod.JavaCourseFactory;
import com.youkol.designpattern.factorymethod.PythonCourseFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========== Factory Method Pattern start ...");
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse javaCourse = javaCourseFactory.create();
        javaCourse.record();

        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonCourseFactory.create();
        pythonCourse.record();
        
        System.out.println("========== Factory Method Pattern end ...");

    }
    
}
