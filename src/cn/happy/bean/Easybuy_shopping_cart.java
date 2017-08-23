package cn.happy.bean;

public class Easybuy_shopping_cart {
    private Long esc_id;
    private Long esc_user_id;
    private Long esc_product_id;
    private Long esc_quantity;
    private java.sql.Timestamp esc_create_time;
    private java.sql.Timestamp esc_update_time;

    public Long getEsc_id() {
        return esc_id;
    }

    public void setEsc_id(Long esc_id) {
        this.esc_id = esc_id;
    }

    public Long getEsc_user_id() {
        return esc_user_id;
    }

    public void setEsc_user_id(Long esc_user_id) {
        this.esc_user_id = esc_user_id;
    }

    public Long getEsc_product_id() {
        return esc_product_id;
    }

    public void setEsc_product_id(Long esc_product_id) {
        this.esc_product_id = esc_product_id;
    }

    public Long getEsc_quantity() {
        return esc_quantity;
    }

    public void setEsc_quantity(Long esc_quantity) {
        this.esc_quantity = esc_quantity;
    }

    public java.sql.Timestamp getEsc_create_time() {
        return esc_create_time;
    }

    public void setEsc_create_time(java.sql.Timestamp esc_create_time) {
        this.esc_create_time = esc_create_time;
    }

    public java.sql.Timestamp getEsc_update_time() {
        return esc_update_time;
    }

    public void setEsc_update_time(java.sql.Timestamp esc_update_time) {
        this.esc_update_time = esc_update_time;
    }
}
