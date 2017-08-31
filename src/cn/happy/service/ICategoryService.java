package cn.happy.service;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.util.CategoryUtil;
import cn.happy.util.ParentUtil;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by master on 17-8-24.
 */
public interface ICategoryService {
    List<CategoryUtil> getCategoriesByParentId(String epp_id);

    String getImageByParentId(String id);

    boolean deleteCategoriesByParentId(String epp_id);

    boolean deleteCategoriesByCategoryId(String epc_id);

    boolean deleteCategoriesByChildId(String epch_id);

    boolean addChild(String epc_id, String epch_name);

    boolean addCategory(String epp_id, String epc_name);

    boolean addParent(Map<String, String> param);

    List<ParentUtil> getParentUtils();
}
