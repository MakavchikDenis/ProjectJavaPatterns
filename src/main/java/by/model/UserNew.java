package by.model;
import java.util.Arrays;
import java.util.Objects;
import java.io.Serializable;

public class UserNew implements Serializable {
    private String login;
    private byte [] password;

    public UserNew( String login, byte[] password) {

        this.login = login;
        this.password = password;
    }

    public UserNew() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }



    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserNew{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNew userNew = (UserNew) o;
        return Objects.equals(login, userNew.login) &&
                Objects.equals(password, userNew.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }
}
