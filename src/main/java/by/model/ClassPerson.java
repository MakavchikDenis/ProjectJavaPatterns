package by.model;

import java.util.Objects;
import java.io.Serializable;

public class ClassPerson implements Serializable {
    private String name;
    private String surname;
    private String email;

    public ClassPerson(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    };

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassPerson person = (ClassPerson) o;
        return Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getName(), person.getName());

    }
    @Override
    public int hashCode() {
        return Objects.hash( getEmail(), getSurname(), getName());
    }
}
