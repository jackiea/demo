package com.youkol.designpattern.chainofreponsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(15)
@Component
public class CheckParamFilter3 extends AbstractFilter {

    @Override
    public void doFilter(FilterRequest request, FilterResponse response) {
        System.out.println("CheckParamFilter3 doFilter...");
        response.setFilterNext(true);

    }
    
}
