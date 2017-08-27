package cn.happy.util;

import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_parent;

import java.util.List;

/**
 * Created by master on 17-8-24.
 */
public class CategoryUtil {
    private Easybuy_product_parent product_parent;
    private List<Easybuy_product_category> product_categories;

    public Easybuy_product_parent getProduct_parent() {
        return product_parent;
    }

    public void setProduct_parent(Easybuy_product_parent product_parent) {
        this.product_parent = product_parent;
    }

    public List<Easybuy_product_category> getProduct_categories() {
        return product_categories;
    }

    public void setProduct_categories(List<Easybuy_product_category> product_categories) {
        this.product_categories = product_categories;
    }
}
