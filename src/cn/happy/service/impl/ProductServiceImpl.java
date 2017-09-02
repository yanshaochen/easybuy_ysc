package cn.happy.service.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.IProductService;
import cn.happy.util.PageUtil;
import cn.happy.util.ProductAndCategoryListUtil;

import java.util.List;

/**
 *
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

    /*
    get page total records
     */
    @Override
    public int getTotalRecords(String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTotalRecords(searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getTotalRecordsByChildId(String ep_child_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTotalRecordsByChildId(ep_child_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getTotalRecordsByCategoryId(String ep_category_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTotalRecordsByCategoryId(ep_category_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getTotalRecordsByParentId(String ep_parent_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getTotalRecordsByParentId(ep_parent_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ProductAndCategoryListUtil getProductAndCategoryListUtil(String ep_id) {
        ProductAndCategoryListUtil productAndList = new ProductAndCategoryListUtil();
        IProductDAO dao = new ProductDAOImpl();
        Easybuy_product product = null;
        List<Easybuy_product_parent> parents = null;
        List<Easybuy_product_category> categories = null;
        List<Easybuy_product_child> children = null;
        try {
            product = dao.getProductById(ep_id);
            parents = dao.getParents();
            categories = dao.getCategoriesByParentId(product.getEp_parent_id());
            children = dao.getChildrenByCategoryId(product.getEp_category_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        productAndList.setParents(parents);
        productAndList.setCategories(categories);
        productAndList.setChildren(children);
        productAndList.setProduct(product);
        return productAndList;
    }

    @Override
    public List<Easybuy_product> getProductsInPage(PageUtil page, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsInPage(page, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByChildId(PageUtil page, String ep_child_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsInPageByChildId(page, ep_child_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByCategoryId(PageUtil page, String ep_category_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsInPageByCategoryId(page, ep_category_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByParentId(PageUtil page, String ep_parent_id, String searchKey) {
        IProductDAO dao = new ProductDAOImpl();
        try {
            return dao.getProductsInPageByParentId(page, ep_parent_id, searchKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
