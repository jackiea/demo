package com.youkol.designpattern.abastractfactory;

/**
 * Java Product Factory for create java product family.
 * 
 * @author jackiea
 */
public class JavaCourseFactory extends CourseFactory {

    @Override
    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
    
}
