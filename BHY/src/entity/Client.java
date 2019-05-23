package entity;

/**
 * 顾客类
 */
public class Client {
    private int cl_id;//顾客id
    private String cl_name;//顾客姓名
    private String mobile;//顾客手机号码
    private int cl_age;//顾客年龄
    private String cl_sex;//顾客性别
    private String cl_emil;//顾客电子邮箱

    public Client() {
    }

    public Client(int cl_id, String cl_name, String mobile) {
        this.cl_id = cl_id;
        this.cl_name = cl_name;
        this.mobile = mobile;
    }

    public Client(int cl_id, String cl_name, String mobile, int cl_age, String cl_sex, String cl_emil) {
        this.cl_id = cl_id;
        this.cl_name = cl_name;
        this.mobile = mobile;
        this.cl_age = cl_age;
        this.cl_sex = cl_sex;
        this.cl_emil = cl_emil;
    }

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public String getCl_name() {
        return cl_name;
    }

    public void setCl_name(String cl_name) {
        this.cl_name = cl_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCl_age() {
        return cl_age;
    }

    public void setCl_age(int cl_age) {
        this.cl_age = cl_age;
    }

    public String getCl_sex() {
        return cl_sex;
    }

    public void setCl_sex(String cl_sex) {
        this.cl_sex = cl_sex;
    }

    public String getCl_emil() {
        return cl_emil;
    }

    public void setCl_emil(String cl_emil) {
        this.cl_emil = cl_emil;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cl_id=" + cl_id +
                ", cl_name='" + cl_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cl_age=" + cl_age +
                ", cl_sex='" + cl_sex + '\'' +
                ", cl_emil='" + cl_emil + '\'' +
                '}';
    }
}
