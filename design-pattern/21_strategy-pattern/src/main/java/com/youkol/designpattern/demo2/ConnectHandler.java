package com.youkol.designpattern.demo2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(2)
@Slf4j
public class ConnectHandler implements Handler {

    @Override
    public HandleType getType() {
        return HandleType.CONNECT;
    }

    @Override
    public void handle(String message) {
        log.info("CONNECT: {}", message);
    }
}
