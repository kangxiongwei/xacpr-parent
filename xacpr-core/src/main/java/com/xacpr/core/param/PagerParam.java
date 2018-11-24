package com.xacpr.core.param;

/**
 * Create by kangxiongwei on 2018/11/24 下午1:19
 */
public class PagerParam {

    private Integer page = 1;
    private Integer pageSize = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PagerParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
