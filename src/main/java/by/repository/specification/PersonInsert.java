package by.repository.specification;

import java.util.Arrays;
import java.util.List;

public class PersonInsert implements Parameter{
    private String name;
    private String surname;
    private String email;

    public PersonInsert(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(name,surname,email);
    }
}
