package com.xacpr.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kangxiongwei on 2018/11/24 下午12:44
 */
public class PagerModel<T> {

    private Integer page = 1;                       //总共多少页
    private Integer pageSize = 10;                  //每页多少行
    private Long total;                             //总记录数
    private Integer totalPage;                      //总页数
    private List<T> records = new ArrayList<>();    //每页的详细记录

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "PagerModel{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", records=" + records +
                '}';
    }
}
