package entity;

import java.util.Date;

/**
 * 货物（商品）类
 */
public class CargoDao {
    private int c_id;//id
    private String c_name;//货物名称
    private int c_num;//货物数量
    private int d_id;//字典id（货物类别）
    private int s_id;//所属宠物店id
    private Date c_getdate;//进货时间
    private Date c_produceddate;//生产日期
    private Date c_expirationdate;//保质日期

    public CargoDao() {
    }

    public CargoDao(int c_id, String c_name, int c_num, int d_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_num = c_num;
        this.d_id = d_id;
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

    public Date getC_getdate() {
        return c_getdate;
    }

    public void setC_getdate(Date c_getdate) {
        this.c_getdate = c_getdate;
    }

    public Date getC_produceddate() {
        return c_produceddate;
    }

    public void setC_produceddate(Date c_produceddate) {
        this.c_produceddate = c_produceddate;
    }

    public Date getC_expirationdate() {
        return c_expirationdate;
    }

    public void setC_expirationdate(Date c_expirationdate) {
        this.c_expirationdate = c_expirationdate;
    }

    @Override
    public String toString() {
        return "CargoDao{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_num=" + c_num +
                ", d_id=" + d_id +
                ", s_id=" + s_id +
                ", c_getdate=" + c_getdate +
                ", c_produceddate=" + c_produceddate +
                ", c_expirationdate=" + c_expirationdate +
                '}';
    }
}
