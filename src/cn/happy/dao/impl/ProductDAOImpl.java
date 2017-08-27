package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.IProductDAO;
import cn.happy.util.CategoryUtil;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-23.
 */
public class ProductDAOImpl extends BaseDAO implements IProductDAO {

    @Override
    public List<CategoryUtil> getCategories() throws Exception {
        String sql = "select epp_id,epp_name,epp_img,epc_id,epc_name from easybuy_product_category,easybuy_product_parent where easybuy_product_category.epc_parent_id=easybuy_product_parent.epp_id;";
        ResultSet resultSet = executeQuery(sql);
        List<CategoryUtil> categoryUtils = new ArrayList<>();
        //HashMap's get(key) method would have problems if the key is <Object> such as Easybuy_product_parent
        Map<Long, List<Easybuy_product_category>> categories = new HashMap<>();
        while (resultSet.next()) {
            long epp_id = resultSet.getLong("epp_id");
            //create category
            Easybuy_product_category category = new Easybuy_product_category();
            category.setEpc_id(resultSet.getLong("epc_id"));
            category.setEpc_name(resultSet.getString("epc_name"));
            category.setEpc_parent_id(resultSet.getLong("epp_id"));
            //epp_id,epp_name,epp_img,epc_id,epc_name
            if (categories.containsKey(epp_id)) {
                //add category
                categories.get(epp_id).add(category);
            } else {
                //put new parent into map
                categories.put(epp_id, new ArrayList<>());
                //add category
                categories.get(epp_id).add(category);
            }
        }
        resultSet.close();
        closeResources();
        for (Map.Entry<Long, List<Easybuy_product_category>> item : categories.entrySet()
                ) {
            CategoryUtil categoryUtil = new CategoryUtil();
            categoryUtil.setProduct_parent(getParentById(item.getKey()));
            categoryUtil.setProduct_categories(item.getValue());
            categoryUtils.add(categoryUtil);
        }
        return categoryUtils;
    }

    private Easybuy_product_parent getParentById(Long key) throws Exception {
        Easybuy_product_parent parent = new Easybuy_product_parent();
        String sql = "select * from easybuy_product_parent where epp_id=?;";
        ResultSet resultSet = executeQuery(sql, key);
        if (resultSet.next()) {
            parent.setEpp_id(resultSet.getLong("epp_id"));
            parent.setEpp_name(resultSet.getString("epp_name"));
            parent.setEpp_img(resultSet.getString("epp_img"));
        }
        return parent;
    }

    @Override
    public List<Easybuy_product> getTop10() throws Exception {
        String sql = "select * from easybuy_product where ep_istop10!=0 order by ep_istop10 asc limit 10;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product> top10 = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return top10;
    }
}
