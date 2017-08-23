package cn.happy.bean;

public class Easybuy_news {
    private Long en_id;
    private String en_title;
    private String en_content;
    private java.sql.Timestamp en_create_time;
    private java.sql.Timestamp en_modify_time;

    public Long getEn_id() {
        return en_id;
    }

    public void setEn_id(Long en_id) {
        this.en_id = en_id;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getEn_content() {
        return en_content;
    }

    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }

    public java.sql.Timestamp getEn_create_time() {
        return en_create_time;
    }

    public void setEn_create_time(java.sql.Timestamp en_create_time) {
        this.en_create_time = en_create_time;
    }

    public java.sql.Timestamp getEn_modify_time() {
        return en_modify_time;
    }

    public void setEn_modify_time(java.sql.Timestamp en_modify_time) {
        this.en_modify_time = en_modify_time;
    }
}
