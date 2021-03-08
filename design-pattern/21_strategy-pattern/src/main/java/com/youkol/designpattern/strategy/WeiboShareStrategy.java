package com.youkol.designpattern.strategy;

/**
 * Weibo share strategy implementation for ShareStrategy.
 * 
 * @author jackiea
 */
public class WeiboShareStrategy implements ShareStrategy {

    @Override
    public void share(String option) {
        System.out.println("Weibo option: " + option);
    }
    
}
