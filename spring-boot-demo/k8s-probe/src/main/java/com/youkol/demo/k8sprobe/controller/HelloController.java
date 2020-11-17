package com.youkol.demo.k8sprobe.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello controller.
 * 
 * @author jackeia
 * @date 2020-11-18
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, " + LocalDateTime.now();
    }
    
}
