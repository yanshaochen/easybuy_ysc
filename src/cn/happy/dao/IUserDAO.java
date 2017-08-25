package cn.happy.dao;

/**
 * Created by master on 17-8-25.
 */
public interface IUserDAO {
    boolean isAdmin(String name, String password) throws Exception;
}
