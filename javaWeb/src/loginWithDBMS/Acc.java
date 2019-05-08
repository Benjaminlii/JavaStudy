package loginWithDBMS;

public class Acc {
    private int id;
    private String uname;
    private String upwd;

    public Acc() {
    }

    public Acc(String uname, String upsd) {
        this.uname = uname;
        this.upwd = upsd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
