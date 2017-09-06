package cn.happy.service.impl;

import cn.happy.bean.Easybuy_user;
import cn.happy.dao.IUserValidateDAO;
import cn.happy.dao.impl.UserValidateDAOImpl;
import cn.happy.service.IUserValidateService;
import cn.happy.util.Md5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by master on 17-9-6.
 */
public class UserValidateServiceImpl implements IUserValidateService {
    @Override
    public boolean ValidateByUser(String loginName) {
        IUserValidateDAO dao = new UserValidateDAOImpl();
        try {
            return dao.ValidateByUser(loginName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setUser(Map<String, String> param) {
        IUserValidateDAO dao = new UserValidateDAOImpl();
        try {
            return dao.setUser(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Easybuy_user getUserByUserName(String eu_username) {
        IUserValidateDAO dao = new UserValidateDAOImpl();
        try {
            return dao.getUserByUserName(eu_username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean corrected(String name, String password) {
        IUserValidateDAO dao = new UserValidateDAOImpl();
        String passwordInDB = null;
        try {
            passwordInDB = dao.getEncryptedPwdByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (passwordInDB == null)
                return false;
            else
                return Md5Util.validPassword(password, passwordInDB);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
