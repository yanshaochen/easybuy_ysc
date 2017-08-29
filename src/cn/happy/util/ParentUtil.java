package cn.happy.util;

import cn.happy.bean.Easybuy_product_parent;

import java.util.List;

/**
 * Parent,category and children
 * Created by master on 17-8-30.
 */
public class ParentUtil {
    Easybuy_product_parent product_parent;
    List<CategoryUtil> categoryUtils;

    public Easybuy_product_parent getProduct_parent() {
        return product_parent;
    }

    public void setProduct_parent(Easybuy_product_parent product_parent) {
        this.product_parent = product_parent;
    }

    public List<CategoryUtil> getCategoryUtils() {
        return categoryUtils;
    }

    public void setCategoryUtils(List<CategoryUtil> categoryUtils) {
        this.categoryUtils = categoryUtils;
    }
}
