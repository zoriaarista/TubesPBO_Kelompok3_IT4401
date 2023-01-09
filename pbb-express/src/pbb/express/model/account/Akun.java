package pbb.express.model.account;

public abstract class Akun {

    private String username;

    private String password;


    public abstract void login();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
