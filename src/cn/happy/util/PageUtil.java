package cn.happy.util;

public class PageUtil {
    private int totalCount;
    private int pageSize = 3;
    private int pageCount;
    private int pageIndex;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            this.pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public PageUtil(int totalCount, int pageSize, int pageCount, int pageIndex) {
        super();
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.pageIndex = pageIndex;
    }

    public PageUtil() {
        super();
    }

    @Override
    public String toString() {
        return "PageUtil [totalCount=" + totalCount + ", pageSize=" + pageSize
                + ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
    }

}
