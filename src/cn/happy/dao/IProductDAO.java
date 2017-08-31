package cn.happy.dao;

import cn.happy.bean.Easybuy_product;
import cn.happy.util.PageUtil;

import java.util.List;

/**
 * Created by master on 17-8-30.
 */
public interface IProductDAO {
    List<Easybuy_product> getLimit() throws Exception;

    List<Easybuy_product> getTop10() throws Exception;

    List<Easybuy_product> getProductsByParentId(String epp_id) throws Exception;

    int getTotalRecords() throws Exception;

    List<Easybuy_product> getProductsInPage(PageUtil page) throws Exception;
}
