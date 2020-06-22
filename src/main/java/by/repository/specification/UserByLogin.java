package by.repository.specification;

import java.util.List;
import java.util.Arrays;

public class UserByLogin implements Parameter {

    private String login;
    public UserByLogin(String login) {
        this.login = login;
    }
    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login);
    }

}
