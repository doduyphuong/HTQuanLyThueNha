package pojos;
// Generated Sep 27, 2019 9:45:19 AM by Hibernate Tools 4.3.1

/**
 * Account generated by hbm2java
 */
public class Account implements java.io.Serializable {

    private String username;
    private String password;
    private int role;
    private int maNv;

    public Account() {
    }

    public Account(String username, String password, byte role, int maNv) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.maNv = maNv;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getMaNv() {
        return this.maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    @Override
    public String toString() {
        return "username: " + this.username + ", password: " + this.password + ", role: " + this.role + ", maNv: " + this.maNv;
    }

}
