package cn.happy.service;

import cn.happy.bean.Easybuy_product;
import cn.happy.util.PageUtil;
import cn.happy.util.ProductAndCategoryListUtil;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by master on 17-8-30.
 */
public interface IProductService {
    List<Easybuy_product> getLimit();

    List<Easybuy_product> getTop10();

    List<Easybuy_product> getProductsByParentId(String epp_id);

    int getTotalRecords(String searchKey);

    List<Easybuy_product> getProductsInPage(PageUtil page, String searchKey);

    List<Easybuy_product> getProductsInPageByChildId(PageUtil page, String ep_child_id, String searchKey);

    List<Easybuy_product> getProductsInPageByCategoryId(PageUtil page, String ep_category_id, String searchKey);

    List<Easybuy_product> getProductsInPageByParentId(PageUtil page, String ep_parent_id, String searchKey);

    int getTotalRecordsByChildId(String ep_child_id, String searchKey);

    int getTotalRecordsByCategoryId(String ep_category_id, String searchKey);

    int getTotalRecordsByParentId(String ep_parent_id, String searchKey);

    ProductAndCategoryListUtil getProductAndCategoryListUtil(String ep_id);

    boolean updateProduct(Map<String, String> param);

    String getImageByProductId(String id);

    boolean addProduct(Map<String, String> param);

    boolean deleteProductById(String ep_id);

    Easybuy_product getProductByEp_id(String ep_id);
}
