package cn.happy.service.impl;

import cn.happy.dao.IAdminDAO;
import cn.happy.dao.impl.AdminDAOImpl;
import cn.happy.service.IAdminLoginService;
import cn.happy.util.Md5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Created by master on 17-8-25.
 */
public class AdminLoginServiceImpl implements IAdminLoginService {
    @Override
    public boolean isAdmin(String name, String password) {
        IAdminDAO dao = new AdminDAOImpl();
        String passwordInDB = null;
        try {
            passwordInDB = dao.getEncryptedPwdByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return Md5Util.validPassword(password, passwordInDB);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setNewPassword(String name, String renewpass) {
        IAdminDAO dao = new AdminDAOImpl();
        try {
            return dao.setNewPassword(name, Md5Util.getEncryptedPwd(renewpass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
