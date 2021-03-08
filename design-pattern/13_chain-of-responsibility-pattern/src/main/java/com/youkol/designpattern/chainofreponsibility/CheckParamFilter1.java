package com.youkol.designpattern.chainofreponsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
public class CheckParamFilter1 extends AbstractFilter {

    @Override
    public void doFilter(FilterRequest request, FilterResponse response) {
        System.out.println("CheckParamFilter1 doFilter...");
        response.setFilterNext(true);

    }
    
}
