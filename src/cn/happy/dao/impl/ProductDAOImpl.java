package cn.happy.dao.impl;

import cn.happy.dao.BaseDAO;
import cn.happy.dao.IProductDAO;
import cn.happy.util.CategoryUtil;

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
        String sql = "select epc_name,easybuy_product_category.epc_parent_id,epp_name from easybuy_product_category,easybuy_product_parent where easybuy_product_category.epc_parent_id=easybuy_product_parent.epp_id;";
        ResultSet resultSet = executeQuery(sql);
        List<CategoryUtil> categoryUtils = new ArrayList<>();
        Map<Integer, List<String>> categories = new HashMap<>();
        while (resultSet.next()) {
            int epc_parent_id = resultSet.getInt("epc_parent_id");
            if (categories.containsKey(epc_parent_id)) {
                categories.get(epc_parent_id).add(resultSet.getString("epc_name"));
            } else {
                categories.put(epc_parent_id, new ArrayList<>());
                categories.get(epc_parent_id).add(resultSet.getString("epp_name"));
                categories.get(epc_parent_id).add(resultSet.getString("epc_name"));
            }
        }
        for (Integer item : categories.keySet()
                ) {
            CategoryUtil categoryUtil = new CategoryUtil();
            categoryUtil.setParentName(categories.get(item).get(0));
            categories.get(item).remove(0);
            categoryUtil.setCategories(categories.get(item));
            categoryUtils.add(categoryUtil);
        }
        return categoryUtils;
    }
}