package entity;

import util.JsonTimeUtil;

import java.sql.Date;

/**
 * 服务类
 */
public class Service {
    private Integer s_id;//服务id
    private Integer p_id;//宠物id
    private String s_isdispose;//是否受处理
    private String s_isfinish;//是否被完成
    private Integer d_id;//字典id（服务类别）
    private Integer e_id;//处理员工id
    private String s_atime;//服务预约时间
    private Float s_price;//服务价格

    public Service() {
    }

    public Service(int s_id, int p_id, String s_isdispose, String s_isfinish, int d_id) {
        this.s_id = s_id;
        this.p_id = p_id;
        this.s_isdispose = s_isdispose;
        this.s_isfinish = s_isfinish;
        this.d_id = d_id;
    }

    public Service(int s_id, int p_id, String s_isDispose, String s_isFinish, int d_id, int e_id, String s_aTime, float s_price) {
        this.s_id = s_id;
        this.p_id = p_id;
        this.s_isdispose = s_isDispose;
        this.s_isfinish = s_isFinish;
        this.d_id = d_id;
        this.e_id = e_id;
        this.s_atime = s_aTime;
        this.s_price = s_price;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
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

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getS_atime() {
        return s_atime;
    }

    public void setS_atime(Date s_atime) {
        this.s_atime = JsonTimeUtil.getdate(s_atime);
    }

    public Float getS_price() {
        return s_price;
    }

    public void setS_price(Float s_price) {
        this.s_price = s_price;
    }

    @Override
    public String toString() {
        return "Service{" +
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
