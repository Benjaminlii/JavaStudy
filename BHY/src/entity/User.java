package entity;

public class User {
    private int uid = 0;
    private String uname = null;
    private String upwd = null;
    private String mobile = null;
    private String emil = null;

    public User() {
    }

    public User(int uid, String uname, String upwd, String mobile, String emil) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.mobile = mobile;
        this.emil = emil;
    }

    public User(String uname, String upwd, String mobile, String emil) {
        this.uname = uname;
        this.upwd = upwd;
        this.mobile = mobile;
        this.emil = emil;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emil='" + emil + '\'' +
                '}';
    }
}
