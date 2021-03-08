package com.youkol.designpattern.factorymethod;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
