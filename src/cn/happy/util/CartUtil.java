package cn.happy.util;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_user;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by master on 17-9-7.
 */
public class CartUtil implements Serializable {

    private List<CartSub> cartSubs;

    public List<CartSub> getCartSubs() {
        return cartSubs;
    }

    public void setCartSubs(List<CartSub> cartSubs) {
        this.cartSubs = cartSubs;
    }

    public class CartSub implements Serializable {

        private Easybuy_user user;
        private Easybuy_product product;
        private int esc_quantity;
        private double totalPrice;

        public Easybuy_user getUser() {
            return user;
        }

        public void setUser(Easybuy_user user) {
            this.user = user;
        }

        public Easybuy_product getProduct() {
            return product;
        }

        public void setProduct(Easybuy_product product) {
            this.product = product;
        }

        public int getEsc_quantity() {
            return esc_quantity;
        }

        public void setEsc_quantity(int esc_quantity) {
            this.esc_quantity = esc_quantity;
            setTotalPrice(product.getEp_price() * esc_quantity);
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }

}
