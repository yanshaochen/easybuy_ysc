package cn.happy.service;

import cn.happy.util.CartUtil;

/**
 * Created by master on 17-9-7.
 */
public interface ICartService {
    CartUtil initCartUtils(String ep_id, String quantity);

    void addCart(CartUtil cartUtil, String ep_id, String quantity);
}
