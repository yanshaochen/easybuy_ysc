package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_product;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.ICartDAO;
import cn.happy.util.CartUtil;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by master on 17-9-8.
 */
public class CartDAOImpl extends BaseDAO implements ICartDAO {
    @Override
    public CartUtil getCartByUser(Long eu_id) throws Exception {
        CartUtil cartUtil = new CartUtil();
        cartUtil.setCartSubs(new ArrayList<>());
        String sql = "select esc_id,esc_product_id,esc_quantity from easybuy_shopping_cart where esc_user_id=?;";
        ResultSet resultSet = executeQuery(sql, eu_id);
        while (resultSet.next()) {
            CartUtil.CartSub cartSub = cartUtil.new CartSub();
            cartSub.setEsc_id(resultSet.getLong("esc_id"));
            cartSub.setProduct(getProductById(resultSet.getLong("esc_product_id")));
            cartSub.setEsc_quantity(resultSet.getInt("esc_quantity"));
            cartUtil.getCartSubs().add(cartSub);
        }
        resultSet.close();
        closeResources();
        return cartUtil;
    }

    @Override
    public boolean setCartByUser(Long eu_id, CartUtil cartUtil) throws Exception {
        int count = 0;
        String sql = "delete from easybuy_shopping_cart where esc_user_id=?;";
        count += executeUpdate(sql, eu_id);
        for (CartUtil.CartSub item : cartUtil.getCartSubs()
                ) {
            String sql1 = "insert into easybuy_shopping_cart values (default," + eu_id + ",?,?);";
            count += executeUpdate(sql1, item.getProduct().getEp_id(), item.getEsc_quantity());
        }
        return count > 0;
    }

    @Override
    public boolean updateCartByIdAndQuantity(long esc_id, int esc_quantity) throws Exception {
        String sql = "update easybuy_shopping_cart set esc_quantity=? where esc_id=?;";
        int count = executeUpdate(sql, esc_quantity, esc_id);
        return count > 0;
    }

    @Override
    public boolean deleteCartById(long esc_id) throws Exception {
        String sql = "delete from easybuy_shopping_cart where esc_id=?;";
        int count = executeUpdate(sql, esc_id);
        return count > 0;
    }

    private Easybuy_product getProductById(long esc_product_id) throws Exception {
        String sql = "select ep_id,ep_name,ep_img,ep_description,ep_title,ep_price,ep_brand,ep_stock,ep_parent_id,ep_category_id,ep_child_id from easybuy_product where ep_id=?;";
        ResultSet resultSet = executeQuery(sql, esc_product_id);
        List<Easybuy_product> products = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_product.class);
        return products.get(0);
    }
}
