package entity;

/**
 * Êý¾Ý×ÖµäÀà
 */
public class Dictionary {
    private int d_id;//×Öµäid
    private int d_par_id;//¸¸Ä¸×Öµäid
    private String d_name;//×ÖµäÃû³Æ
    private String d_value;//×ÖµäÖµ

    public Dictionary() {
    }

    public Dictionary(int d_id, String d_name, String d_value) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_value = d_value;
    }

    public Dictionary(int d_id, int d_par_id, String d_name, String d_value) {
        this.d_id = d_id;
        this.d_par_id = d_par_id;
        this.d_name = d_name;
        this.d_value = d_value;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getD_par_id() {
        return d_par_id;
    }

    public void setD_par_id(int d_par_id) {
        this.d_par_id = d_par_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "d_id=" + d_id +
                ", d_par_id=" + d_par_id +
                ", d_name='" + d_name + '\'' +
                ", d_value='" + d_value + '\'' +
                '}';
    }
}
