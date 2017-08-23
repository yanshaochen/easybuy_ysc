package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.IProductDAO;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-23.
 */
public class ProductDAOImpl extends BaseDAO implements IProductDAO {

    @Override
    public int getProductRecords(Map<String, String> params) throws Exception {
        return 0;
    }

    @Override
    public List<Easybuy_product> getProductList(int pageIndex, int pageSize, Map<String, String> params) throws Exception {
        return null;
    }
}
