package cn.happy.dao;


import cn.happy.bean.Easybuy_product;
import cn.happy.util.CategoryUtil;

import java.util.List;

/**
 * 用户信息接口层
 * Created by master on 17-8-3.
 */
public interface IProductDAO {


    List<CategoryUtil> getCategories() throws Exception;

    List<Easybuy_product> getTop10() throws Exception;
}
