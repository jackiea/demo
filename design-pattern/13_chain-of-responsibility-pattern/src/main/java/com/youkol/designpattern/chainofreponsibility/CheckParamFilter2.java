package com.youkol.designpattern.chainofreponsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10)
@Component
public class CheckParamFilter2 extends AbstractFilter {

    @Override
    public void doFilter(FilterRequest request, FilterResponse response) {
        System.out.println("CheckParamFilter2 doFilter...");
        response.setFilterNext(false); // 不再往下执行

    }
    
}
