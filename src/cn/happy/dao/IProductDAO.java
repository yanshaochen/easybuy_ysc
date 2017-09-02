package cn.happy.dao;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.util.PageUtil;
import cn.happy.util.ProductAndCategoryListUtil;

import java.util.List;

/**
 *
 * Created by master on 17-8-30.
 */
public interface IProductDAO {
    List<Easybuy_product> getLimit() throws Exception;

    List<Easybuy_product> getTop10() throws Exception;

    List<Easybuy_product> getProductsByParentId(String epp_id) throws Exception;

    int getTotalRecords(String searchKey) throws Exception;

    List<Easybuy_product> getProductsInPage(PageUtil page, String searchKey) throws Exception;

    List<Easybuy_product> getProductsInPageByChildId(PageUtil page, String ep_child_id, String searchKey) throws Exception;

    List<Easybuy_product> getProductsInPageByCategoryId(PageUtil page, String ep_category_id, String searchKey) throws Exception;

    List<Easybuy_product> getProductsInPageByParentId(PageUtil page, String ep_parent_id, String searchKey) throws Exception;

    int getTotalRecordsByChildId(String ep_child_id, String searchKey) throws Exception;

    int getTotalRecordsByCategoryId(String ep_category_id, String searchKey) throws Exception;

    int getTotalRecordsByParentId(String ep_parent_id, String searchKey) throws Exception;

    Easybuy_product getProductById(String ep_id) throws Exception;

    List<Easybuy_product_parent> getParents() throws Exception;

    List<Easybuy_product_category> getCategoriesByParentId(Long ep_parent_id) throws Exception;

    List<Easybuy_product_child> getChildrenByCategoryId(Long ep_category_id) throws Exception;
}
