package by.builder;

import by.model.ClassPerson;
import by.exception.RepositoryException;
import by.repository.dbConstants.PersonTableConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder <ClassPerson>{

    @Override
    public ClassPerson build(ResultSet set) throws RepositoryException {
        try {
            String name=set.getString(PersonTableConstant.NAMEL.getFielName());
            String surname=set.getString(PersonTableConstant.SURNAMEL.getFielName());
            String email=set.getString(PersonTableConstant.EMAIL.getFielName());
            return new ClassPerson(name,surname,email);
        }
        catch (SQLException e){
            throw new RepositoryException(e.getMessage(),e);
        }
    }

}

