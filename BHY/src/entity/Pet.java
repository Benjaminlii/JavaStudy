package entity;

/**
 * ������
 */
public class Pet {
    private int p_id;//����id
    private int cl_id;//�����˿�id
    private int d_id;//�ֵ���Ϣ��Ʒ�֣�id
    private int s_id;//�����id
    private int p_age;//��������
    private String p_sex;//�����Ա�
    private float p_height;//��������
    private String p_healthy;//���｡��״��

    public Pet() {
    }

    public Pet(int p_id, int cl_id, int d_id) {
        this.p_id = p_id;
        this.cl_id = cl_id;
        this.d_id = d_id;
    }

    public Pet(int p_id, int cl_id, int d_id, int s_id, int p_age, String p_sex, float p_height, String p_healthy) {
        this.p_id = p_id;
        this.cl_id = cl_id;
        this.d_id = d_id;
        this.s_id = s_id;
        this.p_age = p_age;
        this.p_sex = p_sex;
        this.p_height = p_height;
        this.p_healthy = p_healthy;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
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

    public int getP_age() {
        return p_age;
    }

    public void setP_age(int p_age) {
        this.p_age = p_age;
    }

    public String getP_sex() {
        return p_sex;
    }

    public void setP_sex(String p_sex) {
        this.p_sex = p_sex;
    }

    public float getP_height() {
        return p_height;
    }

    public void setP_height(float p_height) {
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
                ", s_id=" + s_id +
                ", p_age=" + p_age +
                ", p_sex='" + p_sex + '\'' +
                ", p_height=" + p_height +
                ", p_healthy='" + p_healthy + '\'' +
                '}';
    }
}
