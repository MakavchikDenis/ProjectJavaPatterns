package by.builder;

import by.exception.RepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder <T> {
    T build (ResultSet set) throws RepositoryException;
}
