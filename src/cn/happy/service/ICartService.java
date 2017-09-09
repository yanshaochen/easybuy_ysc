package cn.happy.service;

import cn.happy.util.CartUtil;

/**
 *
 * Created by master on 17-9-7.
 */
public interface ICartService {
    CartUtil initCartUtils(String ep_id, String quantity);

    void addCart(CartUtil cartUtil, String ep_id, String quantity);

    CartUtil getCartByUser(Long eu_id);

    boolean setCartByUser(Long eu_id, CartUtil cartUtil);

    void merge(CartUtil cartUtilDB, CartUtil cartUtil);

    boolean updateCartByIdAndQuantity(long esc_id, int esc_quantity);

    boolean deleteCartById(long esc_id);
}
