package cn.happy.dao;


import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.util.CategoryUtil;

import java.util.List;

/**
 * 用户信息接口层
 * Created by master on 17-8-3.
 */
public interface ICategoryDAO {


    List<CategoryUtil> getCategoriesByParentId(String epp_id) throws Exception;

    List<Easybuy_product> getTop10() throws Exception;

    String getImageByParentId(String id) throws Exception;

    boolean deleteCategoriesByid(String epp_id) throws Exception;

    List<Easybuy_product_parent> getParents() throws Exception;
}
