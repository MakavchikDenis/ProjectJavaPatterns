package by.repository;

import by.model.ClassPerson;
import by.builder.PersonBuilder;
import by.exception.RepositoryException;
import by.model.ClassPerson;
import by.repository.dbConstants.PersonTableConstant;
import by.repository.specification.Parameter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepository extends AbstractRepository <ClassPerson>{
    private static final String TABLE_NAME = "person";
    public PersonRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }
    @Override
    public List<ClassPerson> query(String sqlString, Parameter paramater) throws
            RepositoryException {
        String query = sqlString;
        List<ClassPerson> persons = executeQuery(query,new PersonBuilder(),
                paramater.getParameters());
        return persons;
    }
    @Override
    public Optional<ClassPerson> queryForSingleResult(String sqlString, Parameter
            parameter) throws RepositoryException {
        List<ClassPerson> person = query(sqlString, parameter);
        return person.size() == 1 ?
                Optional.of(person.get(0)) :
                Optional.empty();
    }
    public Map<String,Object> getFields(ClassPerson person) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(PersonTableConstant.NAMEL.getFielName(), person.getName());
        fields.put(PersonTableConstant.SURNAMEL.getFielName(), person.getSurname());
        fields.put(PersonTableConstant.EMAIL.getFielName(), person.getEmail());
        return fields;
    }
}
