package entity;

import util.DateStringUtil;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 员工类
 */
public class Employee {
    private Integer e_id;//员工id
    private String e_name;//姓名
    private Integer e_salary;//工资
    private Integer st_id;//所属宠物店id
    private Integer d_id;//字典id（职务）
    private Integer u_id;//用户id
    private String e_sex;//性别
    private Integer e_age;//年龄
    private String e_time;//入职时间

    public Employee() {
    }

    public Employee(String e_name, int e_salary, int st_id, int d_id) {
        this.e_name = e_name;
        this.e_salary = e_salary;
        this.st_id = st_id;
        this.d_id = d_id;
    }

    public Employee(int e_id, String e_name, int e_salary, int st_id, int d_id) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_salary = e_salary;
        this.st_id = st_id;
        this.d_id = d_id;
    }

    public Employee(int e_id, String e_name, int e_salary, int st_id, int d_id, int u_id, String e_sex, int e_age, String e_time) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_salary = e_salary;
        this.st_id = st_id;
        this.d_id = d_id;
        this.u_id = u_id;
        this.e_sex = e_sex;
        this.e_age = e_age;
        this.e_time = e_time;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Integer getE_salary() {
        return e_salary;
    }

    public void setE_salary(Integer e_salary) {
        this.e_salary = e_salary;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public Integer getE_age() {
        return e_age;
    }

    public void setE_age(Integer e_age) {
        this.e_age = e_age;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(Timestamp e_time) {
        this.e_time = DateStringUtil.dateToString(e_time);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_salary=" + e_salary +
                ", st_id=" + st_id +
                ", d_id=" + d_id +
                ", u_id=" + u_id +
                ", e_sex='" + e_sex + '\'' +
                ", e_age=" + e_age +
                ", e_time=" + e_time +
                '}';
    }
}
