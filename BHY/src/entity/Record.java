package entity;

import java.util.Date;

/**
 * 销售记录类
 */
public class Record {
    private Integer r_id;//销售记录id
    private Integer cl_id;//购买者id
    private Integer st_id;//宠物店id
    private Integer c_id;//货物id
    private Date r_time;//时间
    private Float r_price;//售出价格
    private Integer r_num;//购买数量
    private String r_pattern;//支付方式

    public Record() {
    }

    public Record(int r_id, int cl_id, int st_id, int c_id, Date r_time, float r_price, int r_num) {
        this.r_id = r_id;
        this.cl_id = cl_id;
        this.st_id = st_id;
        this.c_id = c_id;
        this.r_time = r_time;
        this.r_price = r_price;
        this.r_num = r_num;
    }

    public Record(int r_id, int cl_id, int st_id, int c_id, Date r_time, float r_price, int r_num, String r_pattern) {
        this.r_id = r_id;
        this.cl_id = cl_id;
        this.st_id = st_id;
        this.c_id = c_id;
        this.r_time = r_time;
        this.r_price = r_price;
        this.r_num = r_num;
        this.r_pattern = r_pattern;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getCl_id() {
        return cl_id;
    }

    public void setCl_id(Integer cl_id) {
        this.cl_id = cl_id;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public Float getR_price() {
        return r_price;
    }

    public void setR_price(Float r_price) {
        this.r_price = r_price;
    }

    public Integer getR_num() {
        return r_num;
    }

    public void setR_num(Integer r_num) {
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
        return "Record{" +
                "r_id=" + r_id +
                ", cl_id=" + cl_id +
                ", st_id=" + st_id +
                ", c_id=" + c_id +
                ", r_time=" + r_time +
                ", r_price=" + r_price +
                ", r_num=" + r_num +
                ", r_pattern='" + r_pattern + '\'' +
                '}';
    }
}
