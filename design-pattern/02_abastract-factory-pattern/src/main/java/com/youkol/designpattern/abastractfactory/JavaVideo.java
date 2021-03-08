package com.youkol.designpattern.abastractfactory;

/**
 * Create java product family.
 * Java video implementation for IVideo interface.
 * 
 * @author jackiea
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("java record...");
    }
    
}
