package entity;

import java.util.Date;

/**
 * 员工类
 */
public class EmployeeDao {
    private int e_id;//员工id
    private String username;//用户名
    private String password;//密码
    private String e_name;//姓名
    private int e_salary;//工资
    private int s_id;//所属宠物店id
    private int d_id;//字典id（职务）
    private String e_sex;//性别
    private int e_age;//年龄
    private Date e_time;//入职时间

    public EmployeeDao() {
    }

    public EmployeeDao(int e_id, String username, String password, String e_name, int e_salary, int s_id, int d_id) {
        this.e_id = e_id;
        this.username = username;
        this.password = password;
        this.e_name = e_name;
        this.e_salary = e_salary;
        this.s_id = s_id;
        this.d_id = d_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_salary() {
        return e_salary;
    }

    public void setE_salary(int e_salary) {
        this.e_salary = e_salary;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public int getE_age() {
        return e_age;
    }

    public void setE_age(int e_age) {
        this.e_age = e_age;
    }

    public Date getE_time() {
        return e_time;
    }

    public void setE_time(Date e_time) {
        this.e_time = e_time;
    }

    @Override
    public String toString() {
        return "EmployeeDao{" +
                "e_id=" + e_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", e_name='" + e_name + '\'' +
                ", e_salary=" + e_salary +
                ", s_id=" + s_id +
                ", d_id=" + d_id +
                ", e_sex='" + e_sex + '\'' +
                ", e_age=" + e_age +
                ", e_time=" + e_time +
                '}';
    }
}
