package com.laoxu.gamedog.framework.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果类
 * <p>bootstrap-table专用</p>
 *
 * @author xusucheng
 * @create 2018-10-23
 *
 **/
public class BtPagingResult<T> {
    private int total ;//总记录数
    private int page; //页码
    private List<T> rows = new ArrayList<T>() ;//分页结果集

    /**
     * 构造函数。
     * @param rows 分页结果集
     * @param currentPage 当前页索引
     * @param pageSize 当前页大小
     * @param total 总记录数
     */
    public BtPagingResult(List<T> rows)
    {
        this.rows = rows;
        this.total = rows.size();
    }


    /**
     * 获取总记录数。
     * @return 总记录数
     */
    public int getRecords()
    {
        return total ;
    }

    /**
     * 设置总记录数。
     * @param total 总记录数
     */
    public void setRecords( int total )
    {
        this.total = total ;
    }


    /**
     * 获取分页结果集。
     * @return 分页结果集
     */
    public List<T> getRows()
    {
        return rows ;
    }

    /**
     * 获取分页结果集。
     * @param rows 分页结果集
     */
    public void setRows( List<T> rows )
    {
        this.rows = rows ;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
