package Thread.yieldTest;

/**
 * @author sergei
 * @create 2020-04-02
 */
public class User {
    public String name;
    public String pass;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
