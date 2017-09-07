package cn.happy.service.impl;

import cn.happy.dao.IProductDAO;
import cn.happy.dao.impl.ProductDAOImpl;
import cn.happy.service.ICartService;
import cn.happy.util.CartUtil;

import java.util.ArrayList;
import java.util.List;

/**
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
}
