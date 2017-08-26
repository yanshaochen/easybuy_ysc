package cn.happy.dao;

/**
 * Created by master on 17-8-25.
 */
public interface IAdminDAO {

    boolean setNewPassword(String name, String encryptedPwd) throws Exception;

    String getEncryptedPwdByName(String name) throws Exception;
}
