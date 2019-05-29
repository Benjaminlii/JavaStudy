package entity;

public class PetCustom extends Pet {
    private String cl_name;//所属顾客姓名
    private String p_type;//宠物类型
    private String st_name;//宠物店名

    public PetCustom(int p_id, int p_age,
                     String p_sex, float p_height, String p_healthy, String cl_name,
                     String p_type, String st_name) {
        super(p_id, p_age, p_sex, p_height, p_healthy);
        this.cl_name = cl_name;
        this.p_type = p_type;
        this.st_name = st_name;
    }

    public String getCl_name() {
        return cl_name;
    }

    public void setCl_name(String cl_name) {
        this.cl_name = cl_name;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

}
