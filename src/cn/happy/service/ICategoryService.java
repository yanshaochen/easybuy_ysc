package cn.happy.service;

import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.util.ParentUtil;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by master on 17-8-24.
 */
public interface ICategoryService {

    String getImageByParentId(String id);

    boolean deleteCategoriesByParentId(String epp_id);

    boolean deleteCategoriesByCategoryId(String epc_id);

    boolean deleteCategoriesByChildId(String epch_id);

    boolean addChild(String epc_id, String epch_name);

    boolean addCategory(String epp_id, String epc_name);

    boolean addParent(Map<String, String> param);

    List<ParentUtil> getParentUtils();

    List<Easybuy_product_category> getCategoriesByParentId(String epp_id);

    List<Easybuy_product_child> getChildrenByCategoryId(String epc_id);

    boolean modChild(String epch_id, String epch_name);

    boolean doModCategory(String epc_id, String epc_name);

    boolean doModParent(Map<String, String> param);
}
