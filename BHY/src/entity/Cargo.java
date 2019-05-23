package entity;

import java.util.Date;

/**
 * �����Ʒ����
 */
public class Cargo {
    private int c_id;//id
    private String c_name;//��������
    private int c_num;//��������
    private int d_id;//�ֵ�id���������
    private int s_id;//���������id
    private Date c_getDate;//����ʱ��
    private Date c_producedDate;//��������
    private Date c_expirationDate;//��������

    public Cargo() {
    }

    public Cargo(int c_id, String c_name, int c_num, int d_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
    }

    public Cargo(int c_id, String c_name, int c_num, int d_id, int s_id, Date c_getDate, Date c_producedDate, Date c_expirationDate) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
        this.s_id = s_id;
        this.c_getDate = c_getDate;
        this.c_producedDate = c_producedDate;
        this.c_expirationDate = c_expirationDate;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public Date getC_getDate() {
        return c_getDate;
    }

    public void setC_getdate(Date c_getdate) {
        this.c_getDate = c_getdate;
    }

    public Date getC_producedDate() {
        return c_producedDate;
    }

    public void setC_producedDate(Date c_produceddate) {
        this.c_producedDate = c_produceddate;
    }

    public Date getC_expirationDate() {
        return c_expirationDate;
    }

    public void setC_expirationDate(Date c_expirationdate) {
        this.c_expirationDate = c_expirationdate;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_num=" + c_num +
                ", d_id=" + d_id +
                ", s_id=" + s_id +
                ", c_getDate=" + c_getDate +
                ", c_producedDate=" + c_producedDate +
                ", c_expirationDate=" + c_expirationDate +
                '}';
    }
}
