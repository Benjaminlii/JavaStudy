package entity;

import java.util.Date;

/**
 * �������
 */
public class StoreDao {
    private int s_id;//�����id
    private int d_id;//�ֵ�id������
    private int e_id;//�곤id
    private String s_address;//��ַ
    private Date s_time;//����ʱ��

    public StoreDao() {
    }

    public StoreDao(int s_id, int d_id) {
        this.s_id = s_id;
        this.d_id = d_id;
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

    public Date getS_time() {
        return s_time;
    }

    public void setS_time(Date s_time) {
        this.s_time = s_time;
    }

    @Override
    public String toString() {
        return "StoreDao{" +
                "s_id=" + s_id +
                ", d_id=" + d_id +
                ", e_id=" + e_id +
                ", s_address='" + s_address + '\'' +
                ", s_time=" + s_time +
                '}';
    }
}
