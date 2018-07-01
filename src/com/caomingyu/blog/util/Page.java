package com.caomingyu.blog.util;

public class Page {
    private int start;
    private int count;
    private String params;
    private int total;
    private int last;
    private static final int defaultCount = 5;

    public void setLast(int last) {
        this.last = last;
    }

    private Page() {
        count = defaultCount;
    }

    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getTotalPage() {
        int totalPage;
        if (0 == total % count)
            totalPage = total / count;
        else
            totalPage = total / count + 1;
        return totalPage > 0 ? totalPage : 1;
    }

    public int getLast() {
        int last;
        if (0 == total % count)
            last = total - count;
        else last = total - total % count;
        return last<0?0:last;
    }

    public boolean ishasPrevious() {
        return start != 0;

    }

    public boolean ishasNext() {
        return start != getLast();
    }
}
