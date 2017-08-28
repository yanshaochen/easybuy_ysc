package cn.happy.service.impl;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.ICategoryDAO;
import cn.happy.dao.impl.CategoryDAOImpl;
import cn.happy.service.ICategoryService;
import cn.happy.util.CategoryUtil;

import java.util.List;

/**
 * Created by master on 17-8-24.
 */
public class CategoryServiceImpl implements ICategoryService {
    @Override
    public List<CategoryUtil> getCategoriesByParentId(String epp_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getCategoriesByParentId(epp_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getImageByParentId(String id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getImageByParentId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteCategoriesByid(String epp_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.deleteCategoriesByid(epp_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Easybuy_product_parent> getParents() {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getParents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
