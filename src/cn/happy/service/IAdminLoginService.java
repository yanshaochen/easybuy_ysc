package cn.happy.service;

/**
 * Created by master on 17-8-25.
 */
public interface IAdminLoginService {
    boolean isAdmin(String name, String password);

    boolean setNewPassword(String name, String renewpass);
}
