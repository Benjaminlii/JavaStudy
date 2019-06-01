package entity;

public class PetCustom extends Pet {
    private String cl_name;//所属顾客姓名
    private String d_value;//宠物类型
    private String st_address;//宠物店名

    public PetCustom() {
    }

    public PetCustom(int p_id, int p_age, String p_sex, float p_height, String p_healthy,
                     String cl_name, String d_value, String st_address) {
        super(p_id, p_age, p_sex, p_height, p_healthy);
        this.cl_name = cl_name;
        this.d_value = d_value;
        this.st_address = st_address;
    }

    public String getCl_name() {
        return cl_name;
    }

    public void setCl_name(String cl_name) {
        this.cl_name = cl_name;
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    public String getSt_address() {
        return st_address;
    }

    public void setSt_address(String st_address) {
        this.st_address = st_address;
    }
}
