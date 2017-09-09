package cn.happy.dao;

import cn.happy.util.CartUtil;

/**
 *
 * Created by master on 17-9-8.
 */
public interface ICartDAO {
    CartUtil getCartByUser(Long eu_id) throws Exception;

    boolean setCartByUser(Long eu_id, CartUtil cartUtil) throws Exception;

    boolean updateCartByIdAndQuantity(long esc_id, int esc_quantity) throws Exception;

    boolean deleteCartById(long esc_id) throws Exception;
}
