package entity;

import java.util.Date;

/**
 * ���ۼ�¼��
 */
public class RecordDao {
    private int r_id;//���ۼ�¼id
    private int cl_id;//������id
    private int s_id;//�����id
    private int c_id;//����id
    private Date r_time;//ʱ��
    private float r_price;//�۳��۸�
    private int r_num;//��������
    private String r_pattern;//֧����ʽ

    public RecordDao() {
    }

    public RecordDao(int r_id, int cl_id, int s_id, int c_id, Date r_time, float r_price, int r_num) {
        this.r_id = r_id;
        this.cl_id = cl_id;
        this.s_id = s_id;
        this.c_id = c_id;
        this.r_time = r_time;
        this.r_price = r_price;
        this.r_num = r_num;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public float getR_price() {
        return r_price;
    }

    public void setR_price(float r_price) {
        this.r_price = r_price;
    }

    public int getR_num() {
        return r_num;
    }

    public void setR_num(int r_num) {
        this.r_num = r_num;
    }

    public String getR_pattern() {
        return r_pattern;
    }

    public void setR_pattern(String r_pattern) {
        this.r_pattern = r_pattern;
    }

    @Override
    public String toString() {
        return "RecordDao{" +
                "r_id=" + r_id +
                ", cl_id=" + cl_id +
                ", s_id=" + s_id +
                ", c_id=" + c_id +
                ", r_time=" + r_time +
                ", r_price=" + r_price +
                ", r_num=" + r_num +
                ", r_pattern='" + r_pattern + '\'' +
                '}';
    }
}
