package cn.happy.util_pages;

import cn.happy.bean.Easybuy_product;

import java.util.List;

/**
 * Created by master on 17-8-10.
 */
public class ProductPage {

    private int pageIndex = 1;
    private int pageSize = 10;
    private int totalCount;
    private int totalPageCount;
    private List<Easybuy_product> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int currPageNo) {
        this.pageIndex = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if (this.totalCount > 0)
            totalPageCount = this.totalCount % pageSize == 0 ? this.totalCount / pageSize : this.totalCount / pageSize + 1;
        else totalPageCount = 0;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<Easybuy_product> getList() {
        return list;
    }

    public void setList(List<Easybuy_product> list) {
        this.list = list;
    }
}
