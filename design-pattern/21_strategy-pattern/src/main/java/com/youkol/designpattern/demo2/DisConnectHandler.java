package com.youkol.designpattern.demo2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class DisConnectHandler implements Handler {

    @Override
    public HandleType getType() {
        return HandleType.DISCONNECT;
    }

    @Override
    public void handle(String message) {
        log.info("DISCONNECT: {}", message);
    }
}
