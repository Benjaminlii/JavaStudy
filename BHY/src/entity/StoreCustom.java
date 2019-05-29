package entity;

import java.util.Date;

public class StoreCustom extends Store {
    private String st_grade;//宠物店级别
    private String e_name;//员工姓名

    public StoreCustom(int s_id, String s_address, Date s_time, String st_grade, String e_name) {
        super(s_id, s_address, s_time);
        this.st_grade = st_grade;
        this.e_name = e_name;
    }

    public String getSt_grade() {
        return st_grade;
    }

    public void setSt_grade(String st_grade) {
        this.st_grade = st_grade;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
}
