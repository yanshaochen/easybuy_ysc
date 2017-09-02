package cn.happy.util;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;

import java.util.List;

/**
 * Created by master on 17-9-2.
 */
public class ProductAndCategoryListUtil {
    List<Easybuy_product_parent> parents;
    List<Easybuy_product_category> categories;
    List<Easybuy_product_child> children;
    Easybuy_product product;

    public List<Easybuy_product_parent> getParents() {
        return parents;
    }

    public void setParents(List<Easybuy_product_parent> parents) {
        this.parents = parents;
    }

    public List<Easybuy_product_category> getCategories() {
        return categories;
    }

    public void setCategories(List<Easybuy_product_category> categories) {
        this.categories = categories;
    }

    public List<Easybuy_product_child> getChildren() {
        return children;
    }

    public void setChildren(List<Easybuy_product_child> children) {
        this.children = children;
    }

    public Easybuy_product getProduct() {
        return product;
    }

    public void setProduct(Easybuy_product product) {
        this.product = product;
    }
}
