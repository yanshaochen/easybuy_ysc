package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.IProductDAO;
import cn.happy.util.PageUtil;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.List;

/**
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
        List<Easybuy_product> limit8 = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
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
        List<Easybuy_product> top10 = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
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
        List<Easybuy_product> products = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }

    @Override
    public int getTotalRecords() throws Exception {
        int count = -1;
        String sql = "select count(1) as count from easybuy_product;";
        ResultSet resultSet = executeQuery(sql);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        resultSet.close();
        closeResources();
        return count;
    }

    @Override
    public List<Easybuy_product> getProductsInPage(PageUtil page) throws Exception {
        String sql = "select ep_id,ep_name,ep_description,ep_price,ep_stock,ep_child_id,ep_img,ep_brand,ep_isgroup,ep_intopbar,ep_title,ep_category_id,ep_parent_id,ep_limit,epp_name,epc_name,epch_name " +
                "from easybuy_product,easybuy_product_parent,easybuy_product_category,easybuy_product_child where " +
                "ep_child_id=epch_id and epch_category_id=epc_id and epc_parent_id=epp_id and ep_delflag!=1 limit ?,?;";
        ResultSet resultSet = executeQuery(sql, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_product> products = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return products;
    }
}
