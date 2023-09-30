package cinemasystem.bean;
/*Person共性：登录管理,都有账号和密码*/
public class Person{
    private String ID;

    private String password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
