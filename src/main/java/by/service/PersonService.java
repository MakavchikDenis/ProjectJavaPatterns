package by.service;
import by.exception.RepositoryException;
import by.exception.ServiceException;
import by.model.ClassPerson;
import by.repository.PersonRepository;
import by.repository.RepositoryCreator;
import java.util.List;

public class PersonService {
    public List<ClassPerson> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(ClassPerson person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
