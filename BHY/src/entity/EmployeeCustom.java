package entity;

import java.util.Date;

public class EmployeeCustom extends Employee {
    private String st_name;//宠物店名字
    private String e_type;//员工类型
    private String username;//员工登陆的用户名

    public EmployeeCustom(int e_id, String e_name, int e_salary, int s_id, int d_id, int u_id, String e_sex, int e_age, Date e_time, String st_name, String e_type, String username) {
        super(e_id, e_name, e_salary, s_id, d_id, u_id, e_sex, e_age, e_time);
        this.st_name = st_name;
        this.e_type = e_type;
        this.username = username;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
