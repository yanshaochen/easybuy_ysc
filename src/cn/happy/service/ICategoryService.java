package cn.happy.service;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.util.CategoryUtil;

import java.util.List;

/**
 * Created by master on 17-8-24.
 */
public interface ICategoryService {
    List<CategoryUtil> getCategoriesByParentId(String epp_id);

    String getImageByParentId(String id);

    boolean deleteCategoriesByid(String epp_id);

    List<Easybuy_product_parent> getParents();
}
