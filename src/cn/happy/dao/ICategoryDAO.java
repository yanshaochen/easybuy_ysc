package cn.happy.dao;


import cn.happy.bean.Easybuy_product;
import cn.happy.util.CategoryUtil;
import cn.happy.util.ParentUtil;

import java.util.List;
import java.util.Map;

/**
 * Parent,Category,Child Manager Interface
 * Created by master on 17-8-3.
 */
public interface ICategoryDAO {


    List<CategoryUtil> getCategoriesByParentId(String epp_id) throws Exception;

    String getImageByParentId(String id) throws Exception;

    boolean deleteCategoriesByParentId(String epp_id) throws Exception;

    boolean deleteCategoriesByCategoryId(String epc_id) throws Exception;

    boolean deleteCategoriesByChildId(String epch_id) throws Exception;

    boolean addChild(String epc_id, String epch_name) throws Exception;

    boolean addCategory(String epp_id, String epc_name) throws Exception;

    boolean addParent(Map<String, String> param) throws Exception;

    List<ParentUtil> getParentUtils() throws Exception;
}
