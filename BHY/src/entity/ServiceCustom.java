package entity;

import java.util.Date;

public class ServiceCustom extends Service {
    private String s_type;//服务类型
    private String e_name;//处理员工姓名

    public ServiceCustom(int s_id, int p_id, String s_isDispose, String s_isFinish,
                         int d_id, int e_id, Date s_aTime, float s_price,
                         String s_type, String e_name) {
        super(s_id, p_id, s_isDispose, s_isFinish, d_id, e_id, s_aTime, s_price);
        this.s_type = s_type;
        this.e_name = e_name;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
}
