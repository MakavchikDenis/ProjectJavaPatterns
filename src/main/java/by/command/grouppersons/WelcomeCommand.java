package by.command.grouppersons;
import by.command.Command;
import by.command.CommandResult;
import by.exception.IncorrectDataException;
import by.exception.ServiceException;
import by.model.ClassPerson;
import by.service.PersonService;
import by.util.pages.Page;
import static by.command.grouppersons.constant.GroupConstant.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class WelcomeCommand implements Command{
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<ClassPerson> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}
