package entity;


public class StoreCustom extends Store {
    private String d_value;//宠物店级别
    private String e_name;//员工姓名

    public StoreCustom() {
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
}
