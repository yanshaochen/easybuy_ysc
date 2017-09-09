package cn.happy.service.impl;

import cn.happy.dao.ICartDAO;
import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.CartDAOImpl;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.ICartService;
import cn.happy.util.CartUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by master on 17-9-7.
 */
public class CartServiceImpl implements ICartService {
    @Override
    public CartUtil initCartUtils(String ep_id, String quantity) {
        CartUtil cartUtil = new CartUtil();
        CartUtil.CartSub cartSub = cartUtil.new CartSub();
        IProductDAO dao = new ProductDAOImpl();
        try {
            cartSub.setProduct(dao.getProductById(ep_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cartSub.setEsc_quantity(Integer.parseInt(quantity));
        List<CartUtil.CartSub> cartSubs = new ArrayList<>();
        cartSubs.add(cartSub);
        cartUtil.setCartSubs(cartSubs);
        return cartUtil;
    }

    @Override
    public void addCart(CartUtil cartUtil, String ep_id, String quantity) {

        boolean isNewCartSub = true;
        for (CartUtil.CartSub item : cartUtil.getCartSubs()
                ) {
            if (String.valueOf(item.getProduct().getEp_id()).equals(ep_id)) {
                item.setEsc_quantity(item.getEsc_quantity() + Integer.parseInt(quantity));
                isNewCartSub = false;
            }
        }
        if (isNewCartSub) {
            CartUtil.CartSub newCartSub = cartUtil.new CartSub();
            IProductDAO dao = new ProductDAOImpl();
            try {
                newCartSub.setProduct(dao.getProductById(ep_id));
            } catch (Exception e) {
                e.printStackTrace();
            }
            newCartSub.setEsc_quantity(Integer.parseInt(quantity));
            cartUtil.getCartSubs().add(newCartSub);
        }
    }

    @Override
    public CartUtil getCartByUser(Long eu_id) {
        ICartDAO dao = new CartDAOImpl();
        try {
            return dao.getCartByUser(eu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setCartByUser(Long eu_id, CartUtil cartUtil) {
        ICartDAO dao = new CartDAOImpl();
        try {
            return dao.setCartByUser(eu_id, cartUtil);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    not a sql operation
     */
    @Override
    public void merge(CartUtil cartUtilDB, CartUtil cartUtil) {
        for (CartUtil.CartSub itemCache : cartUtil.getCartSubs()
                ) {
            boolean isNewFlag = true;
            //DB maybe empty,so inner circle
            for (CartUtil.CartSub itemDB : cartUtilDB.getCartSubs()
                    ) {
                if (itemDB.getProduct().getEp_id().equals(itemCache.getProduct().getEp_id())) {
                    itemDB.setEsc_quantity(itemCache.getEsc_quantity());
                    isNewFlag = false;
                }
            }
            if (isNewFlag) {
                cartUtilDB.getCartSubs().add(itemCache);
            }
        }
    }

    @Override
    public boolean updateCartByIdAndQuantity(long esc_id, int esc_quantity) {
        ICartDAO dao = new CartDAOImpl();
        try {
            return dao.updateCartByIdAndQuantity(esc_id, esc_quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCartById(long esc_id) {
        ICartDAO dao = new CartDAOImpl();
        try {
            return dao.deleteCartById(esc_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
