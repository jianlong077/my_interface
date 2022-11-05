package com.haichao.page;

import java.io.Serializable;
import java.util.Map;

public class PageFindParam<T> /*extends Page<T>*/ implements Serializable {
    private int pageNum=0;
    private int pageSize=0;
    private Map<String,Object> findParams;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getFindParams() {
        return findParams;
    }

    public void setFindParams(Map<String, Object> findParams) {
        this.findParams = findParams;
    }
}
