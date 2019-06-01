package entity;

/**
 * 宠物类
 */
public class Pet {
    private Integer p_id;//宠物id
    private Integer cl_id;//所属顾客id
    private Integer d_id;//字典信息（品种）id
    private Integer st_id;//宠物店id
    private Integer p_age;//宠物年龄
    private String p_sex;//宠物性别
    private Float p_height;//宠物体重
    private String p_healthy;//宠物健康状况

    public Pet() {
    }

    public Pet(int p_id, int cl_id, int d_id) {
        this.p_id = p_id;
        this.cl_id = cl_id;
        this.d_id = d_id;
    }

    public Pet(int p_id, int cl_id, int d_id, int st_id, int p_age, String p_sex, float p_height, String p_healthy) {
        this.p_id = p_id;
        this.cl_id = cl_id;
        this.d_id = d_id;
        this.st_id = st_id;
        this.p_age = p_age;
        this.p_sex = p_sex;
        this.p_height = p_height;
        this.p_healthy = p_healthy;
    }

    public Pet(int p_id, int p_age, String p_sex, float p_height, String p_healthy) {
        this.p_id = p_id;
        this.p_age = p_age;
        this.p_sex = p_sex;
        this.p_height = p_height;
        this.p_healthy = p_healthy;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getCl_id() {
        return cl_id;
    }

    public void setCl_id(Integer cl_id) {
        this.cl_id = cl_id;
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

    public Integer getP_age() {
        return p_age;
    }

    public void setP_age(Integer p_age) {
        this.p_age = p_age;
    }

    public String getP_sex() {
        return p_sex;
    }

    public void setP_sex(String p_sex) {
        this.p_sex = p_sex;
    }

    public Float getP_height() {
        return p_height;
    }

    public void setP_height(Float p_height) {
        this.p_height = p_height;
    }

    public String getP_healthy() {
        return p_healthy;
    }

    public void setP_healthy(String p_healthy) {
        this.p_healthy = p_healthy;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "p_id=" + p_id +
                ", cl_id=" + cl_id +
                ", d_id=" + d_id +
                ", st_id=" + st_id +
                ", p_age=" + p_age +
                ", p_sex='" + p_sex + '\'' +
                ", p_height=" + p_height +
                ", p_healthy='" + p_healthy + '\'' +
                '}';
    }
}
