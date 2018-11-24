package com.xacpr.core.util;

import com.xacpr.core.model.PagerModel;
import com.xacpr.core.param.PagerParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kangxiongwei on 2018/11/24 下午12:51
 */
public class PagerHelper {

    /**
     * 计算分页的起始索引位置
     *
     * @param page
     * @param pageSize
     * @return
     */
    public static Integer getPageIndex(Integer page, Integer pageSize) {
        page = page == null || page <= 0 ? 1 : page;
        pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        return ((page - 1) * pageSize);
    }

    /**
     * 计算分页的总页数
     *
     * @param total
     * @param pageSize
     * @return
     */
    public static Integer getTotalPage(Long total, Integer pageSize) {
        if (total <= 0) return 1;
        return (int) ((total - 1) / pageSize) + 1;
    }

    /**
     * 封装分页查询结果
     * @return
     */
    public static <T>PagerModel<T> getPageModel(PagerParam param, Long total, List<T> list) {
        PagerModel<T> pager = new PagerModel<>();
        pager.setPage(param.getPage());
        pager.setPageSize(param.getPageSize());
        pager.setTotal(total == null ? 0L : total);
        pager.setTotalPage(PagerHelper.getTotalPage(total, pager.getPageSize()));
        pager.setRecords(list == null ? new ArrayList<>() : list);
        return pager;
    }

}
