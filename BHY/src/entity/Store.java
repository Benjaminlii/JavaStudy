package entity;

import java.util.Date;

/**
 * �������
 */
public class Store {
    private int st_id;//�����id
    private int d_id;//�ֵ�id������
    private int e_id;//�곤id
    private String st_address;//��ַ
    private Date st_time;//����ʱ��

    public Store() {
    }

    public Store(int s_id, int d_id) {
        this.st_id = s_id;
        this.d_id = d_id;
    }

    public Store(int s_id, int d_id, int e_id, String s_address, Date s_time) {
        this.st_id = s_id;
        this.d_id = d_id;
        this.e_id = e_id;
        this.st_address = s_address;
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

    public String getSt_address() {
        return st_address;
    }

    public void setSt_address(String st_address) {
        this.st_address = st_address;
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
                ", st_address='" + st_address + '\'' +
                ", st_time=" + st_time +
                '}';
    }
}