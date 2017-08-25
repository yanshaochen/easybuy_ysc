package cn.happy.service.impl;

import cn.happy.dao.IUserDAO;
import cn.happy.dao.impl.UserDAOImpl;
import cn.happy.service.IAdminLoginService;

/**
 * Created by master on 17-8-25.
 */
public class AdminLoginServiceImpl implements IAdminLoginService {
    @Override
    public boolean isAdmin(String name, String password) {
        IUserDAO dao = new UserDAOImpl();
        try {
            return dao.isAdmin(name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
