package com.youkol.designpattern;

import com.youkol.designpattern.simplefactory.ICourse;
import com.youkol.designpattern.simplefactory.CourseFactory;
import com.youkol.designpattern.simplefactory.JavaCourse;
import com.youkol.designpattern.simplefactory.PythonCourse;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========== Simple Factory Pattern start ...");
        CourseFactory factory = new CourseFactory();

        ICourse javaCourse = factory.create(JavaCourse.class);
        javaCourse.record();

        ICourse pythonCourse = factory.create(PythonCourse.class);
        pythonCourse.record();
        
        System.out.println("========== Simple Factory Pattern end ...");

    }
    
}
