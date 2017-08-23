package cn.happy.bean;

public class Easybuy_product_category {
    private Long epc_id;
    private String epc_name;
    private Long epc_parent_id;

    public Long getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(Long epc_id) {
        this.epc_id = epc_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public Long getEpc_parent_id() {
        return epc_parent_id;
    }

    public void setEpc_parent_id(Long epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }
}
