package by.repository.specification;

import java.util.*;

public class UserByLoginPassword  implements Parameter{

    private String login;
    private byte [] password;

    public UserByLoginPassword(String login, byte [] password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login, password);
    }


}
