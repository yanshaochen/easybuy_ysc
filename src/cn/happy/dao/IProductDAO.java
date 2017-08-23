package cn.happy.dao;


import cn.happy.bean.Easybuy_product;

import java.util.List;
import java.util.Map;

/**
 * 用户信息接口层
 * Created by master on 17-8-3.
 */
public interface IProductDAO {

    int getProductRecords(Map<String, String> params) throws Exception;

    List<Easybuy_product> getProductList(int pageIndex, int pageSize, Map<String, String> params) throws Exception;
}
