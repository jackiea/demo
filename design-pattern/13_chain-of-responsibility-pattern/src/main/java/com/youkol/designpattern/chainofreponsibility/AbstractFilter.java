package com.youkol.designpattern.chainofreponsibility;

public abstract class AbstractFilter {
    private AbstractFilter nextFilter;

    public void setNextFilter(AbstractFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public AbstractFilter getLastFilter() {
        if (this.nextFilter != null) {
            return this.nextFilter.getLastFilter();
        }

        return this;
    }

    public void filter(FilterRequest request, FilterResponse response) {
        doFilter(request, response);
        if (response.isFilterNext() && nextFilter != null) {
            nextFilter.filter(request, response);
        }
    }

    public abstract void doFilter(FilterRequest request, FilterResponse response);
}
