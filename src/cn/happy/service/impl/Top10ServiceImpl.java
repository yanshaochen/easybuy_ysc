package cn.happy.service.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.ITop10Service;

import java.util.List;

/**
 * Created by master on 17-8-25.
 */
public class Top10ServiceImpl implements ITop10Service {
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
}
