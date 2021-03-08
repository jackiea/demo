package com.youkol.designpattern.strategy;

public class ShareStrategyContext {

    private String type;

    private ShareStrategy strategy;

    public ShareStrategyContext(String type, ShareStrategy strategy) {
        this.type = type;
        this.strategy = strategy;
    }

    public ShareStrategy getStrategy() {
        return strategy;
    }

    public boolean support(String type) {
        return this.type.equals(type);
    }
}
