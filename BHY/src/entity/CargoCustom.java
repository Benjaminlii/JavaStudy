package entity;

public class CargoCustom extends Cargo {
    private String c_name;//货物类型
    private String st_name;//宠物店名字


    public String getC_type() {
        return c_name;
    }

    public void setC_type(String c_name) {
        this.c_name = c_name;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

}
