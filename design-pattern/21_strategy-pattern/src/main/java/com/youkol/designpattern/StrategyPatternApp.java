package com.youkol.designpattern;

import com.youkol.designpattern.demo2.HandleType;
import com.youkol.designpattern.demo2.HandlerService;
import com.youkol.designpattern.strategy.Share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class StrategyPatternApp implements ApplicationRunner {

    @Autowired
    private HandlerService handlerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        handlerService.handle(HandleType.CONNECT, "This is a connect.");
        log.info("=======================");
        handlerService.handle(HandleType.DISCONNECT, "This is a disconnect.");

    }

    public static void main(String[] args) {
        SpringApplication.run(StrategyPatternApp.class, args);

        // 演示示例
        Share share = new Share();
        share.share("Wechat");
        share.share("Weibo");
        System.out.println("share end...");
    }
}
