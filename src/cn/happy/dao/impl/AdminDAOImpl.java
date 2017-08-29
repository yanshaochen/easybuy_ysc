package cn.happy.dao.impl;

import cn.happy.dao.BaseDAO;
import cn.happy.dao.IAdminDAO;

import java.sql.ResultSet;

/**
 * Admin Manager
 * Created by master on 17-8-26.
 */
public class AdminDAOImpl extends BaseDAO implements IAdminDAO {

    @Override
    public boolean setNewPassword(String name, String encryptedPwd) throws Exception {
        String sql = "update easybuy_admin set ea_password=? where ea_name=?;";
        int count = executeUpdate(sql, encryptedPwd, name);
        closeResources();
        return count > 0;
    }

    @Override
    public String getEncryptedPwdByName(String name) throws Exception {
        String sql = "select ea_password from easybuy_admin where ea_name=? limit 1;";
        ResultSet resultSet = executeQuery(sql, name);
        String encryptedPwd = null;
        if (resultSet.next()) {
            encryptedPwd = resultSet.getString("ea_password");
        }
        resultSet.close();
        closeResources();
        return encryptedPwd;
    }
}
