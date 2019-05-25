package entity;

import java.util.Date;

/**
 * 服务类
 */
public class Service {
    private int s_id;//服务id
    private int p_id;//宠物id
    private String s_isDispose;//是否受处理
    private String s_isFinish;//是否被完成
    private int d_id;//字典id（服务类别）
    private int e_id;//处理员工id
    private Date s_aTime;//服务预约时间
    private float s_price;//服务价格

    public Service() {
    }

    public Service(int s_id, int p_id, String s_isdispose, String s_isfinish, int d_id) {
        this.s_id = s_id;
        this.p_id = p_id;
        this.s_isDispose = s_isdispose;
        this.s_isFinish = s_isfinish;
        this.d_id = d_id;
    }

    public Service(int s_id, int p_id, String s_isDispose, String s_isFinish, int d_id, int e_id, Date s_aTime, float s_price) {
        this.s_id = s_id;
        this.p_id = p_id;
        this.s_isDispose = s_isDispose;
        this.s_isFinish = s_isFinish;
        this.d_id = d_id;
        this.e_id = e_id;
        this.s_aTime = s_aTime;
        this.s_price = s_price;
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

    public String getS_isDispose() {
        return s_isDispose;
    }

    public void setS_isDispose(String s_isDispose) {
        this.s_isDispose = s_isDispose;
    }

    public String getS_isFinish() {
        return s_isFinish;
    }

    public void setS_isFinish(String s_isFinish) {
        this.s_isFinish = s_isFinish;
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

    public Date getS_aTime() {
        return s_aTime;
    }

    public void setS_aTime(Date s_aTime) {
        this.s_aTime = s_aTime;
    }

    public float getS_price() {
        return s_price;
    }

    public void setS_price(float s_price) {
        this.s_price = s_price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "s_id=" + s_id +
                ", p_id=" + p_id +
                ", s_isDispose='" + s_isDispose + '\'' +
                ", s_isFinish='" + s_isFinish + '\'' +
                ", d_id=" + d_id +
                ", e_id=" + e_id +
                ", s_aTime=" + s_aTime +
                ", s_price=" + s_price +
                '}';
    }
}
