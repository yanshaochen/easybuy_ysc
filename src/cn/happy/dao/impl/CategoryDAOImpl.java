package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.ICategoryDAO;
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
public class CategoryDAOImpl extends BaseDAO implements ICategoryDAO {

    /*
    依据父级ID获取二三级分类
     */
    @Override
    public List<CategoryUtil> getCategoriesByParentId(String epp_id) throws Exception {
        String sql = "select epc_id,epc_name,epch_id,epch_name " +
                "from easybuy_product_child,easybuy_product_category " +
                "where epch_category_id=epc_id and epc_parent_id=?;";
        ResultSet resultSet = executeQuery(sql, epp_id);
        List<CategoryUtil> categoryUtils = new ArrayList<>();
        /*HashMap's get(key) method would have problems if the key is <Object> such as Easybuy_product_parent
        because the hashcode is different*/
        Map<Long, List<Easybuy_product_child>> children = new HashMap<>();
        while (resultSet.next()) {
            long epc_id = resultSet.getLong("epc_id");
            //create category
            Easybuy_product_child child = new Easybuy_product_child();
            child.setEpch_id(resultSet.getLong("epch_id"));
            child.setEpch_name(resultSet.getString("epch_name"));
            child.setEpch_category_id(resultSet.getLong("epc_id"));
            //epc_id,epc_name,epch_id,epch_name
            if (children.containsKey(epc_id)) {
                //add category
                children.get(epc_id).add(child);
            } else {
                //put new parent into map
                children.put(epc_id, new ArrayList<>());
                //add category
                children.get(epc_id).add(child);
            }
        }
        resultSet.close();
        closeResources();
        for (Map.Entry<Long, List<Easybuy_product_child>> item : children.entrySet()
                ) {
            CategoryUtil categoryUtil = new CategoryUtil();
            categoryUtil.setProduct_category(getCategoryById(item.getKey()));
            categoryUtil.setProduct_children(item.getValue());
            categoryUtils.add(categoryUtil);
        }
        return categoryUtils;
    }

    private Easybuy_product_category getCategoryById(Long key) throws Exception {
        Easybuy_product_category category = new Easybuy_product_category();
        String sql = "select * from easybuy_product_category where epc_id=?;";
        ResultSet resultSet = executeQuery(sql, key);
        if (resultSet.next()) {
            category.setEpc_id(resultSet.getLong("epc_id"));
            category.setEpc_name(resultSet.getString("epc_name"));
            category.setEpc_parent_id(resultSet.getLong("epc_parent_id"));
        }
        resultSet.close();
        closeResources();
        return category;
    }

    /*
    获取限时抢购或者Top10等内容
     */
    @Override
    public List<Easybuy_product> getTop10() throws Exception {
        String sql = "select * from easybuy_product where ep_intopbar!=0 order by ep_intopbar asc limit 10;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product> top10 = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product.class);
        resultSet.close();
        closeResources();
        return top10;
    }

    /*
    依据获取父级分类图片
     */
    @Override
    public String getImageByParentId(String id) throws Exception {
        String sql = "select epp_img from easybuy_product_parent where epp_id=?;";
        ResultSet resultSet = executeQuery(sql, id);
        String epp_img = null;
        if (resultSet.next()) {
            epp_img = resultSet.getString("epp_img");
        }
        resultSet.close();
        closeResources();
        return epp_img;
    }

    /*
    删除分类的同时逻辑删除商品
     */
    @Override
    public boolean deleteCategoriesByid(String epp_id) throws Exception {
        int count = 0;
        String sql = "update easybuy_product,easybuy_product_category set ep_delflag=1 where ep_category_id=epc_id and epc_parent_id=?;";
        count += executeUpdate(sql, epp_id);
        String sql2 = "delete from easybuy_product_category where epc_parent_id=?";
        count += executeUpdate(sql2, epp_id);
        String sql3 = "delete from easybuy_product_parent where epp_id=?";
        count += executeUpdate(sql3, epp_id);
        return count > 0;
    }

    /*
    获取一级分类
     */
    @Override
    public List<Easybuy_product_parent> getParents() throws Exception {
        String sql = "select * from easybuy_product_parent;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_product_parent> parents = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_product_parent.class);
        resultSet.close();
        closeResources();
        return parents;
    }
}
