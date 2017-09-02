package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.IProductDAO;
import cn.happy.util.PageUtil;
import cn.happy.util.ProductAndCategoryListUtil;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * Created by master on 17-8-30.
 */
public class ProductDAOImpl extends BaseDAO implements IProductDAO {

    /*
    limit buy
     */
    @Override
    public List<Easybuy_product> getLimit() throws Exception {
        String sql = "select * from easybuy_product where ep_limit!=0 order by ep_limit desc limit 8;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product> limit8 = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return limit8;
    }

    /*
    get the top10 or others in hot bar
     */
    @Override
    public List<Easybuy_product> getTop10() throws Exception {
        String sql = "select * from easybuy_product where ep_intopbar!=0 order by ep_intopbar desc limit 10;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product> top10 = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return top10;
    }

    /*
    home page get product
     */
    @Override
    public List<Easybuy_product> getProductsByParentId(String epp_id) throws Exception {
        String sql = "select ep_id,ep_name,ep_price,ep_img from easybuy_product where ep_parent_id=? order by ep_intopbar desc limit 6;";
        ResultSet resultSet = executeQuery(sql, epp_id);
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }

    @Override
    public int getTotalRecords(String searchKey) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_product where ep_name like '%" + searchKey + "%';";
        ResultSet resultSet = executeQuery(sql);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        resultSet.close();
        closeResources();
        return count;
    }

    @Override
    public int getTotalRecordsByChildId(String ep_child_id, String searchKey) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_product where ep_name like '%" + searchKey + "%' and ep_child_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_child_id);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        resultSet.close();
        closeResources();
        return count;
    }

    @Override
    public int getTotalRecordsByCategoryId(String ep_category_id, String searchKey) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_product where ep_name like '%" + searchKey + "%' and ep_category_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_category_id);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        resultSet.close();
        closeResources();
        return count;
    }

    @Override
    public int getTotalRecordsByParentId(String ep_parent_id, String searchKey) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_product where ep_name like '%" + searchKey + "%' and ep_parent_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_parent_id);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        resultSet.close();
        closeResources();
        return count;
    }

    @Override
    public Easybuy_product getProductById(String ep_id) throws Exception {
        String sql = "select ep_id,ep_name,ep_title,ep_price,ep_brand,ep_stock,ep_parent_id,ep_category_id,ep_child_id from easybuy_product where ep_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_id);
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products.get(0);
    }

    @Override
    public List<Easybuy_product_parent> getParents() throws Exception {
        String sql = "select epp_id,epp_name from easybuy_product_parent;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product_parent> parents = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product_parent.class);
        resultSet.close();
        closeResources();
        return parents;
    }

    @Override
    public List<Easybuy_product_category> getCategoriesByParentId(Long ep_parent_id) throws Exception {
        String sql = "select epc_id,epc_name from easybuy_product_category where epc_parent_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_parent_id);
        List<Easybuy_product_category> categories = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product_category.class);
        resultSet.close();
        closeResources();
        return categories;
    }

    @Override
    public List<Easybuy_product_child> getChildrenByCategoryId(Long ep_category_id) throws Exception {
        String sql = "select epch_id,epch_name from easybuy_product_child where epch_category_id=?;";
        ResultSet resultSet = executeQuery(sql, ep_category_id);
        List<Easybuy_product_child> children = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product_child.class);
        resultSet.close();
        closeResources();
        return children;
    }

    @Override
    public List<Easybuy_product> getProductsInPage(PageUtil page, String searchKey) throws Exception {
        String sql = "select ep_id,ep_name,ep_description,ep_price,ep_stock,ep_child_id,ep_img,ep_brand,ep_isgroup,ep_intopbar,ep_title,ep_category_id,ep_parent_id,ep_limit,epp_name,epc_name,epch_name " +
                "from easybuy_product,easybuy_product_parent,easybuy_product_category,easybuy_product_child where " +
                "ep_child_id=epch_id and epch_category_id=epc_id and epc_parent_id=epp_id and ep_delflag!=1 and ep_name like '%" + searchKey + "%' limit ?,?;";
        ResultSet resultSet = executeQuery(sql, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByChildId(PageUtil page, String ep_child_id, String searchKey) throws Exception {
        String sql = "select ep_id,ep_name,ep_description,ep_price,ep_stock,ep_child_id,ep_img,ep_brand,ep_isgroup,ep_intopbar,ep_title,ep_category_id,ep_parent_id,ep_limit,epp_name,epc_name,epch_name " +
                "from easybuy_product,easybuy_product_parent,easybuy_product_category,easybuy_product_child where " +
                "ep_child_id=epch_id and epch_category_id=epc_id and epc_parent_id=epp_id and ep_child_id=? and ep_delflag!=1 and ep_name like '%" + searchKey + "%' limit ?,?;";
        ResultSet resultSet = executeQuery(sql, ep_child_id, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByCategoryId(PageUtil page, String ep_category_id, String searchKey) throws Exception {
        String sql = "select ep_id,ep_name,ep_description,ep_price,ep_stock,ep_child_id,ep_img,ep_brand,ep_isgroup,ep_intopbar,ep_title,ep_category_id,ep_parent_id,ep_limit,epp_name,epc_name,epch_name " +
                "from easybuy_product,easybuy_product_parent,easybuy_product_category,easybuy_product_child where " +
                "ep_child_id=epch_id and epch_category_id=epc_id and epc_parent_id=epp_id and ep_category_id=? and ep_delflag!=1 and ep_name like '%" + searchKey + "%' limit ?,?;";
        ResultSet resultSet = executeQuery(sql, ep_category_id, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }

    @Override
    public List<Easybuy_product> getProductsInPageByParentId(PageUtil page, String ep_parent_id, String searchKey) throws Exception {
        String sql = "select ep_id,ep_name,ep_description,ep_price,ep_stock,ep_child_id,ep_img,ep_brand,ep_isgroup,ep_intopbar,ep_title,ep_category_id,ep_parent_id,ep_limit,epp_name,epc_name,epch_name " +
                "from easybuy_product,easybuy_product_parent,easybuy_product_category,easybuy_product_child where " +
                "ep_child_id=epch_id and epch_category_id=epc_id and epc_parent_id=epp_id and ep_parent_id=? and ep_delflag!=1 and ep_name like '%" + searchKey + "%' limit ?,?;";
        ResultSet resultSet = executeQuery(sql, ep_parent_id, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }
}
