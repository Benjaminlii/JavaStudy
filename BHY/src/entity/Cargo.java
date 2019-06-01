package entity;

import java.util.Date;

/**
 * 货物（商品）类
 */
public class Cargo {
    private Integer c_id;//id
    private String c_name;//货物名称
    private Integer c_num;//货物数量
    private Integer d_id;//字典id（货物类别）
    private Integer st_id;//所属宠物店id
    private Date c_getDate;//进货时间
    private Date c_producedDate;//生产日期
    private Date c_expirationDate;//保质日期

    public Cargo() {
    }

    public Cargo(int c_id, String c_name, int c_num, int d_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
    }

    public Cargo(int c_id, String c_name, int c_num, int d_id, int st_id, Date c_getDate, Date c_producedDate, Date c_expirationDate) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
        this.st_id = st_id;
        this.c_getDate = c_getDate;
        this.c_producedDate = c_producedDate;
        this.c_expirationDate = c_expirationDate;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getC_num() {
        return c_num;
    }

    public void setC_num(Integer c_num) {
        this.c_num = c_num;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
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
                ", st_id=" + st_id +
                ", c_getDate=" + c_getDate +
                ", c_producedDate=" + c_producedDate +
                ", c_expirationDate=" + c_expirationDate +
                '}';
    }
}
