package com.youkol.designpattern.simplefactory;

public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz) {
        if (clazz == null) {
            return null;
        }
        
        try {
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
