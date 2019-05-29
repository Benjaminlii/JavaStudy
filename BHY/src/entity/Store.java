package entity;

import java.util.Date;

/**
 * 宠物店类
 */
public class Store {
    private int st_id;//宠物店id
    private int d_id;//字典id（级别）
    private int e_id;//店长id
    private String s_address;//地址
    private Date st_time;//设立时间

    public Store() {
    }

    public Store(int s_id, int d_id) {
        this.st_id = s_id;
        this.d_id = d_id;
    }

    public Store(int st_id, String s_address, Date st_time) {
        this.st_id = st_id;
        this.s_address = s_address;
        this.st_time = st_time;
    }

    public Store(int s_id, int d_id, int e_id, String s_address, Date s_time) {
        this.st_id = s_id;
        this.d_id = d_id;
        this.e_id = e_id;
        this.s_address = s_address;
        this.st_time = s_time;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public Date getSt_time() {
        return st_time;
    }

    public void setSt_time(Date st_time) {
        this.st_time = st_time;
    }

    @Override
    public String toString() {
        return "Store{" +
                "st_id=" + st_id +
                ", d_id=" + d_id +
                ", e_id=" + e_id +
                ", s_address='" + s_address + '\'' +
                ", st_time=" + st_time +
                '}';
    }
}
