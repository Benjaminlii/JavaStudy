package entity;

/**
 * �û���
 */
public class User {
    private int u_id;//�û�id
    private int d_id;//�ֵ�id(�û�����)
    private String username;//�û���
    private String password;//����

    public User() {
    }

    public User(int d_id, String username, String password) {
        this.d_id = d_id;
        this.username = username;
        this.password = password;
    }

    public User(int u_id, int d_id, String username, String password) {
        this.u_id = u_id;
        this.d_id = d_id;
        this.username = username;
        this.password = password;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", d_id=" + d_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
