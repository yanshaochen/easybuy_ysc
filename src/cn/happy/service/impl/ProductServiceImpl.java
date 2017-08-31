package cn.happy.service.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.IProductService;
import cn.happy.util.PageUtil;

import java.util.List;

/**
 * Created by master on 17-8-30.
 */
public class ProductServiceImpl implements IProductService {

    @Override
    public List<Easybuy_product> getLimit() {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getLimit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product> getTop10() {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTop10();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product> getProductsByParentId(String epp_id) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsByParentId(epp_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getTotalRecords() {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTotalRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Easybuy_product> getProductsInPage(PageUtil page) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsInPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
