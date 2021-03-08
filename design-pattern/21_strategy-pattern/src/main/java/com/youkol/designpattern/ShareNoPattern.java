package com.youkol.designpattern;

public class ShareNoPattern {
    public void share(String option) {
        if (option.equals("Weibo")) {
            System.out.println("Share: Weibo");
        } else if (option.equals("Weichat")) {
            System.out.println("Share: Weichat");
        } else if (option.equals("Weichat-Moments")) {
            System.out.println("Share: Weichat-Moments");
        } else if (option.equals("QQ")) {
            System.out.println("Share: QQ");
        }

        // do somethind.
    }    
}
