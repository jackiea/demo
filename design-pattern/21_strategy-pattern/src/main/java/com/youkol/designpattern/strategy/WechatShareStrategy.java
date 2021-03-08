package com.youkol.designpattern.strategy;

/**
 * Wechat Strategy implementation for ShareStrategy.
 * 
 * @author jackiea
 */
public class WechatShareStrategy implements ShareStrategy {

    @Override
    public void share(String option) {
        System.out.println("Wechat option: " + option);

    }
    
}
