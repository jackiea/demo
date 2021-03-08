package com.youkol.designpattern.chainofreponsibility;

public class FilterResponse {
    private boolean filterNext;

    public boolean isFilterNext() {
        return filterNext;
    }

    public void setFilterNext(boolean filterNext) {
        this.filterNext = filterNext;
    }
    
}
