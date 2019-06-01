package entity;

public class EmployeeCustom extends Employee {
    private String st_address;//宠物店名字
    private String d_value;//员工类型
    private String username;//员工登陆的用户名

    public EmployeeCustom() {
    }

    public String getSt_address() {
        return st_address;
    }

    public void setSt_address(String st_address) {
        this.st_address = st_address;
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
