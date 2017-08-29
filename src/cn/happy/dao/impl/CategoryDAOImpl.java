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
 * Manage easybuy_product_parent,easybuy_product_category,easybuy_product_child
 * Created by master on 17-8-23.
 */
public class CategoryDAOImpl extends BaseDAO implements ICategoryDAO {

    /*
    get the categories and children by parentId
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

    /*
    get categories by categoryId
     */
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
    get the top10 or others in hot bar
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
    get the parents img
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
    get the parents
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

    /*
    delete parent
     */
    @Override
    public boolean deleteCategoriesByParentId(String epp_id) throws Exception {
        int count = 0;
        //Logic delete the products
        String sql = "update easybuy_product set ep_delflag=1 where ep_parent_id=?;";
        count += executeUpdate(sql, epp_id);
        //delete the child
        String sql4 = "delete from easybuy_product_child where epch_category_id in " +
                "(select epc_id from easybuy_product_category where epc_parent_id=?);";
        count += executeUpdate(sql4, epp_id);
        //delete the category
        String sql2 = "delete from easybuy_product_category where epc_parent_id=?";
        count += executeUpdate(sql2, epp_id);
        //delete the parent
        String sql3 = "delete from easybuy_product_parent where epp_id=?";
        count += executeUpdate(sql3, epp_id);
        return count > 0;
    }

    /*
    delete category
     */
    @Override
    public boolean deleteCategoriesByCategoryId(String epc_id) throws Exception {
        int count = 0;
        //Logic delete the products
        String sql = "update easybuy_product set ep_delflag=1 where ep_category_id=?;";
        count += executeUpdate(sql, epc_id);
        //delete the child
        String sql4 = "delete from easybuy_product_child where epch_category_id=?";
        count += executeUpdate(sql4, epc_id);
        //delete the category
        String sql2 = "delete from easybuy_product_category where epc_id=?";
        count += executeUpdate(sql2, epc_id);
        return count > 0;
    }

    /*
    delete child
     */
    @Override
    public boolean deleteCategoriesByChildId(String epch_id) throws Exception {
        int count = 0;
        //Logic delete the products
        String sql = "update easybuy_product set ep_delflag=1 where ep_child_id=?;";
        count += executeUpdate(sql, epch_id);
        //delete the child
        String sql4 = "delete from easybuy_product_child where epch_id=?";
        count += executeUpdate(sql4, epch_id);
        return count > 0;
    }

    /*
    add child
     */
    @Override
    public boolean addChild(String epc_id, String epch_name) throws Exception {
        String sql = "insert into easybuy_product_child values(default,?,?);";
        int count = executeUpdate(sql, epch_name, epc_id);
        return count > 0;
    }

    /*
    add category
     */
    @Override
    public boolean addCategory(String epp_id, String epc_name) throws Exception {
        String sql = "insert into easybuy_product_category values(default,?,?);";
        int count = executeUpdate(sql, epc_name, epp_id);
        return count > 0;
    }

    /*
    add parent
     */
    @Override
    public boolean addParent(Map<String, String> param) throws Exception {
        String sql = "insert into easybuy_product_parent values(default,?,?);";
        int count = executeUpdate(sql, param.get("epp_name"), param.get("epp_img"));
        return count > 0;
    }

}
