package entity;


public class CargoCustom extends Cargo {
    private String d_value;//货物类型
    private String st_name;//宠物店名字

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String c_name) {
        this.d_value = c_name;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

}
