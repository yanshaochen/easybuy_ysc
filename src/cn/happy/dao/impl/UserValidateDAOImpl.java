package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_user;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.IUserValidateDAO;
import cn.happy.util.Md5Util;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-9-6.
 */
public class UserValidateDAOImpl extends BaseDAO implements IUserValidateDAO {
    @Override
    public boolean ValidateByUser(String loginName) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_user where eu_username=?;";
        ResultSet resultSet = executeQuery(sql, loginName);
        if (resultSet.next())
            count = resultSet.getInt("count");
        resultSet.close();
        closeResources();
        return count > 0;
    }

    @Override
    public boolean setUser(Map<String, String> param) throws Exception {
        String sql = "insert into easybuy_user values(default,?,?,?,?,?,default,?,?);";
        int count = executeUpdate(sql, param.get("eu_username"), Md5Util.getEncryptedPwd(param.get("eu_password")), param.get("eu_sex"), param.get("eu_email"), param.get("eu_mobile"), param.get("eu_identitycode"), param.get("eu_realname"));
        return count > 0;
    }

    @Override
    public Easybuy_user getUserByUserName(String eu_username) throws Exception {
        String sql = "select * from easybuy_user where eu_username=?;";
        ResultSet resultSet = executeQuery(sql, eu_username);
        Easybuy_user user = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_user.class).get(0);
        resultSet.close();
        closeResources();
        return user;
    }

    @Override
    public String getEncryptedPwdByName(String name) throws Exception {
        String password = null;
        String sql = "select eu_password from easybuy_user where eu_username=?;";
        ResultSet resultSet = executeQuery(sql, name);
        if (resultSet.next()) {
            password = resultSet.getString("eu_password");
        }
        return password;
    }
}
