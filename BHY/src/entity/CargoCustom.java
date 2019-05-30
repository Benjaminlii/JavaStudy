package entity;

import java.util.Date;

public class CargoCustom extends Cargo {
    private String c_type;//货物类型
    private String st_name;//宠物店名字

    public CargoCustom(int c_id, String c_name, int c_num, int d_id, int s_id,
                       Date c_getDate, Date c_producedDate, Date c_expirationDate,
                       String c_type, String st_name) {
        super(c_id, c_name, c_num, d_id, s_id, c_getDate, c_producedDate, c_expirationDate);
        this.c_type = c_type;
        this.st_name = st_name;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_name) {
        this.c_type = c_name;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

}
