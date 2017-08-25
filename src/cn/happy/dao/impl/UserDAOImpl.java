package cn.happy.dao.impl;

import cn.happy.dao.BaseDAO;
import cn.happy.dao.IUserDAO;

import java.sql.ResultSet;

/**
 * Created by master on 17-8-26.
 */
public class UserDAOImpl extends BaseDAO implements IUserDAO {
    @Override
    public boolean isAdmin(String name, String password) throws Exception {
        String sql = "select count(1) as count from easybuy_admin where ea_name=? and ea_password=?;";
        ResultSet resultSet = executeQuery(sql, name, password);
        int count = 0;
        if (resultSet.next())
            count = resultSet.getInt("count");
        return count > 0;
    }
}
