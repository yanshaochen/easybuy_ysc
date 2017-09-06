package cn.happy.service;

import cn.happy.bean.Easybuy_user;

import java.util.Map;

/**
 * Created by master on 17-9-6.
 */
public interface IUserValidateService {
    boolean ValidateByUser(String loginName);

    boolean setUser(Map<String, String> param);

    Easybuy_user getUserByUserName(String eu_username);

    boolean corrected(String name, String password);
}
