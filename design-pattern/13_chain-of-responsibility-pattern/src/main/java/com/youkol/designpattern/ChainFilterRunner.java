package com.youkol.designpattern;

import com.youkol.designpattern.chainofreponsibility.FilterChain;
import com.youkol.designpattern.chainofreponsibility.FilterRequest;
import com.youkol.designpattern.chainofreponsibility.FilterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ChainFilterRunner implements ApplicationRunner {

    @Autowired
    private FilterChain filterChain;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FilterRequest request = new FilterRequest();
        FilterResponse response = new FilterResponse();
        response.setFilterNext(true);

        System.out.println("=========== Filter chain start ...");

        filterChain.runFilterChain(request, response);

        System.out.println("=========== Filter chain end ...");

    }
    
}
