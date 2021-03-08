package com.youkol.designpattern.abastractfactory;

/**
 * Create java product family.
 * Java classroom note implementation for INote interface.
 * 
 * @author jackiea
 */
public class JavaNote implements INote {

    @Override
    public void edit() {
        System.out.println("java note...");
    }
    
}
