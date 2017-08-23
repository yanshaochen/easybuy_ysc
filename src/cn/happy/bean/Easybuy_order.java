package cn.happy.bean;

public class Easybuy_order {
    private Long eo_id;
    private Long eo_user_id;
    private String eo_user_name;
    private String eo_user_address;
    private String eo_create_time;
    private Double eo_cost;
    private String eo_status;
    private String eo_paytype;

    public Long getEo_id() {
        return eo_id;
    }

    public void setEo_id(Long eo_id) {
        this.eo_id = eo_id;
    }

    public Long getEo_user_id() {
        return eo_user_id;
    }

    public void setEo_user_id(Long eo_user_id) {
        this.eo_user_id = eo_user_id;
    }

    public String getEo_user_name() {
        return eo_user_name;
    }

    public void setEo_user_name(String eo_user_name) {
        this.eo_user_name = eo_user_name;
    }

    public String getEo_user_address() {
        return eo_user_address;
    }

    public void setEo_user_address(String eo_user_address) {
        this.eo_user_address = eo_user_address;
    }

    public String getEo_create_time() {
        return eo_create_time;
    }

    public void setEo_create_time(String eo_create_time) {
        this.eo_create_time = eo_create_time;
    }

    public Double getEo_cost() {
        return eo_cost;
    }

    public void setEo_cost(Double eo_cost) {
        this.eo_cost = eo_cost;
    }

    public String getEo_status() {
        return eo_status;
    }

    public void setEo_status(String eo_status) {
        this.eo_status = eo_status;
    }

    public String getEo_paytype() {
        return eo_paytype;
    }

    public void setEo_paytype(String eo_paytype) {
        this.eo_paytype = eo_paytype;
    }
}
