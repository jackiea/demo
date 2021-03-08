package com.youkol.designpattern.abastractfactory;

/**
 * 抽象工厂CourseFactory类：
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 * 
 * @author jackiea
 */
public abstract class CourseFactory {

    public void init() {
        System.out.println("Initializing the base data...");    
    }

    public abstract INote createNote();

    public abstract IVideo createVideo();
}
