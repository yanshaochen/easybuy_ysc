package cn.happy.util;

import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;

import java.util.List;

/**
 * Created by master on 17-8-24.
 */
public class CategoryUtil {
    //Ajax product_category and product_children
    private Easybuy_product_category product_category;
    private List<Easybuy_product_child> product_children;

    public Easybuy_product_category getProduct_category() {
        return product_category;
    }

    public void setProduct_category(Easybuy_product_category product_category) {
        this.product_category = product_category;
    }

    public List<Easybuy_product_child> getProduct_children() {
        return product_children;
    }

    public void setProduct_children(List<Easybuy_product_child> product_children) {
        this.product_children = product_children;
    }
}
