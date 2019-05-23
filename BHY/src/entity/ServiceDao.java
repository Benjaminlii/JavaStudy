package entity;

import java.util.Date;

/**
 * ������
 */
public class ServiceDao {
    private int s_id;//����id
    private int p_id;//����id
    private String s_isdispose;//�Ƿ��ܴ���
    private String s_isfinish;//�Ƿ����
    private int d_id;//�ֵ�id���������
    private int e_id;//����Ա��id
    private Date s_atime;//����ԤԼʱ��
    private float s_price;//����۸�

    public ServiceDao() {
    }

    public ServiceDao(int s_id, int p_id, String s_isdispose, String s_isfinish, int d_id) {
        this.s_id = s_id;
        this.p_id = p_id;
        this.s_isdispose = s_isdispose;
        this.s_isfinish = s_isfinish;
        this.d_id = d_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getS_isdispose() {
        return s_isdispose;
    }

    public void setS_isdispose(String s_isdispose) {
        this.s_isdispose = s_isdispose;
    }

    public String getS_isfinish() {
        return s_isfinish;
    }

    public void setS_isfinish(String s_isfinish) {
        this.s_isfinish = s_isfinish;
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

    public Date getS_atime() {
        return s_atime;
    }

    public void setS_atime(Date s_atime) {
        this.s_atime = s_atime;
    }

    public float getS_price() {
        return s_price;
    }

    public void setS_price(float s_price) {
        this.s_price = s_price;
    }

    @Override
    public String toString() {
        return "ServiceDao{" +
                "s_id=" + s_id +
                ", p_id=" + p_id +
                ", s_isdispose='" + s_isdispose + '\'' +
                ", s_isfinish='" + s_isfinish + '\'' +
                ", d_id=" + d_id +
                ", e_id=" + e_id +
                ", s_atime=" + s_atime +
                ", s_price=" + s_price +
                '}';
    }
}
