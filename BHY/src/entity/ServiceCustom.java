package entity;


public class ServiceCustom extends Service {
    private String d_value;//服务类型
    private String e_name;//处理员工姓名

    public ServiceCustom() {
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