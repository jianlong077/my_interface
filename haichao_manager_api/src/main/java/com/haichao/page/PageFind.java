package com.haichao.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class PageFind<T> /*extends Page<T>*/ implements Serializable {
    private Double a;
    private Long total;
    private List<T> list;

    public PageFind(List<T> rows) {
        if (rows instanceof Page) {
            PageInfo<T> pageInfo = new PageInfo(rows);
            this.list = rows;
            this.total = pageInfo.getTotal();
        } else {
            this.total = null;
            this.list = rows;
        }
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
