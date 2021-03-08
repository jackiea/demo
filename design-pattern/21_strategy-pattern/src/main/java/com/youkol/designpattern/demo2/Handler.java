package com.youkol.designpattern.demo2;

public interface Handler {

    HandleType getType();

    void handle(String message);
}
