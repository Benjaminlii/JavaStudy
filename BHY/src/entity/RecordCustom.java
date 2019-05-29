package entity;

public class RecordCustom extends Record {
    private String cl_mobile;//顾客手机号
    private String st_name;//宠物店名
    private String c_name;//货物名

    public String getCl_name() {
        return cl_mobile;
    }

    public void setCl_name(String cl_name) {
        this.cl_mobile = cl_name;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getR_name() {
        return c_name;
    }

    public void setR_name(String r_name) {
        this.c_name = r_name;
    }
}
