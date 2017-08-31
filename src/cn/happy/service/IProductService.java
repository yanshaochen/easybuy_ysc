package cn.happy.service;

import cn.happy.bean.Easybuy_product;
import cn.happy.util.PageUtil;

import java.util.List;

/**
 * Created by master on 17-8-30.
 */
public interface IProductService {
    List<Easybuy_product> getLimit();

    List<Easybuy_product> getTop10();

    List<Easybuy_product> getProductsByParentId(String epp_id);

    int getTotalRecords();

    List<Easybuy_product> getProductsInPage(PageUtil page);
}
