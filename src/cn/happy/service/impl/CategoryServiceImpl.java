package cn.happy.service.impl;

import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.dao.ICategoryDAO;
import cn.happy.dao.impl.CategoryDAOImpl;
import cn.happy.service.ICategoryService;
import cn.happy.util.CategoryUtil;
import cn.happy.util.ParentUtil;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by master on 17-8-24.
 */
public class CategoryServiceImpl implements ICategoryService {

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
    public boolean deleteCategoriesByParentId(String epp_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.deleteCategoriesByParentId(epp_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategoriesByCategoryId(String epc_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.deleteCategoriesByCategoryId(epc_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategoriesByChildId(String epch_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.deleteCategoriesByChildId(epch_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addChild(String epc_id, String epch_name) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.addChild(epc_id, epch_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCategory(String epp_id, String epc_name) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.addCategory(epp_id, epc_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addParent(Map<String, String> param) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.addParent(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ParentUtil> getParentUtils() {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getParentUtils();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product_category> getCategoriesByParentId(String epp_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getCategoriesByParentId(epp_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product_child> getChildrenByCategoryId(String epc_id) {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getChildrenByCategoryId(epc_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Easybuy_product_parent> getAllParents() {
        ICategoryDAO dao = new CategoryDAOImpl();
        try {
            return dao.getAllParents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
