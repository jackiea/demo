package com.youkol.designpattern.chainofreponsibility;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilterChain {

    @Autowired
    List<AbstractFilter> filters = new ArrayList<>();

    private AbstractFilter firstFilter;

    @PostConstruct
    public void initializeChainFilter() {
        //把所有调用的逻辑注入到责任链，按照Order排序，越小优先级越高
        for (int i = 0; i < filters.size(); i++) {
            if (i == 0) {
                firstFilter = filters.get(i);
            } else {
                firstFilter.getLastFilter().setNextFilter(filters.get(i));
            }
        }
    }

    public FilterResponse runFilterChain(FilterRequest request, FilterResponse response) {
        firstFilter.filter(request, response);
        return response;
    }
}
