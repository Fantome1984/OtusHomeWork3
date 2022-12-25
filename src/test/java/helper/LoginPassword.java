package helper;

public class LoginPassword  extends BaseUiTest{
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String login = System.getProperty("login");
    private String password=System.getProperty("password");

}
