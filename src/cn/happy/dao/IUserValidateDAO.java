package cn.happy.dao;

import cn.happy.bean.Easybuy_user;

import java.util.Map;

/**
 * Created by master on 17-9-6.
 */
public interface IUserValidateDAO {
    boolean ValidateByUser(String loginName) throws Exception;

    boolean setUser(Map<String, String> param) throws Exception;

    Easybuy_user getUserByUserName(String eu_username) throws Exception;

    String getEncryptedPwdByName(String name) throws Exception;
}
