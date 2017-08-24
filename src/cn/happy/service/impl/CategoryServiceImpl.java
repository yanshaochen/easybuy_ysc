package cn.happy.service.impl;

import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.ICategoryService;
import cn.happy.util.CategoryUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-24.
 */
public class CategoryServiceImpl implements ICategoryService {
    @Override
    public List<CategoryUtil> getCategories() {
        IProductDAO dao = new ProductDAOImpl();
        List<CategoryUtil> categorys = null;
        try {
            categorys = dao.getCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorys;
    }
}
