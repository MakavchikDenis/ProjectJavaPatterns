package by.repository;
import by.builder.UserBuilder;
import by.exception.RepositoryException;
import by.model.UserNew;
import by.repository.dbConstants.UserTableConstant;
import by.repository.specification.Parameter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends AbstractRepository <UserNew> {
    private static final String TABLE_NAME = "users";
    public UserRepository(Connection connection){
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }
    @Override
    public List<UserNew> query(String sqlString, Parameter paramater) throws
            RepositoryException {
        String query = sqlString;
        List<UserNew> users = executeQuery(query,new UserBuilder(),
                paramater.getParameters());
        return users;
    }
    @Override
    public Optional<UserNew> queryForSingleResult(String sqlString, Parameter
            parameter) throws RepositoryException {
        List<UserNew> user = query(sqlString, parameter);
        return user.size() == 1 ?
                Optional.of(user.get(0)) :
                Optional.empty();
    }

    @Override
    public Map<String,Object> getFields(UserNew user) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(UserTableConstant.LOGIN.getfielName(), user.getLogin());
        fields.put(UserTableConstant.PASSWORD.getfielName(), user.getPassword());
        return fields;
    }

}
