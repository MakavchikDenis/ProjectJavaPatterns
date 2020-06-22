package by.service;

import by.exception.RepositoryException;
import by.exception.ServiceException;
import by.model.UserNew;
import by.repository.RepositoryCreator;
import by.repository.SQLHelper;
import by.repository.UserRepository;
import by.repository.specification.UserByLogin;
import by.repository.specification.UserByLoginPassword;
import java.util.Optional;

public class UserService {
    public Optional<UserNew> login(String login, byte[] password) throws
            ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER, params);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public Integer save(UserNew user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN,
                    param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }



}
