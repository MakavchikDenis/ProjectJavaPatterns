package by.repository;
import java.util.List;
import java.util.Optional;
import by.repository.specification.Parameter;
import by.exception.RepositoryException;


public interface Repository <T> {
    List<T> query(String sqlString, Parameter parameter) throws RepositoryException;
    Optional<T> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException;
    List<T> findAll() throws RepositoryException;
    Integer save(T object) throws RepositoryException;
}
