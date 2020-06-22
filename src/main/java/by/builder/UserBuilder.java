package by.builder;

import by.model.UserNew;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.exception.RepositoryException;
import by.repository.dbConstants.UserTableConstant;


public class UserBuilder implements Builder <UserNew>{

    @Override
    public UserNew build(ResultSet set) throws RepositoryException {
        try {
            String login = set.getString(UserTableConstant.LOGIN.getfielName());
            byte[] password = set.getBytes(UserTableConstant.PASSWORD.getfielName());
            return new UserNew(login,password);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
