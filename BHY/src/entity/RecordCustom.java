package entity;

import java.util.Date;

public class RecordCustom extends Record {
    private String cl_mobile;//顾客手机号
    private String st_name;//宠物店名
    private String c_name;//货物名

    public RecordCustom(int r_id, int cl_id, int s_id, int c_id, Date r_time,
                        float r_price, int r_num, String r_pattern, String cl_mobile,
                        String st_name, String c_name) {

        super(r_id, cl_id, s_id, c_id, r_time, r_price, r_num, r_pattern);
        this.cl_mobile = cl_mobile;
        this.st_name = st_name;
        this.c_name = c_name;
    }

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
