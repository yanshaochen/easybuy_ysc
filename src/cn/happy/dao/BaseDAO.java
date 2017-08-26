package cn.happy.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * database Data Access Object
 * 数据库访问工具类
 * Created by yanshaochen on 17-7-25.
 */
public class BaseDAO {
    //three source
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    //get connection
    private Connection getCon() throws Exception {
        if (con == null || con.isClosed()) {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/easyBuy");
            con = ds.getConnection();
        }
        return con;
    }

    //close connection
    protected void closeResources() throws Exception {
        if (rs != null)
            rs.close();
        if (ps != null)
            ps.close();
        if (con != null)
            con.close();
    }

    //DML
    protected int executeUpdate(String sql, Object... objects) throws Exception {
        int count;
        getCon();
        ps = con.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
        }
        count = ps.executeUpdate();
        return count;
    }

    //DQL
    protected ResultSet executeQuery(String sql, Object... objs) throws Exception {
        getCon();
        ps = con.prepareStatement(sql);
        if (objs != null) {
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
        }
        rs = ps.executeQuery();
        return rs;
    }
}