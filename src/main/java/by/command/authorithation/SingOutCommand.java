package by.command.authorithation;

import by.command.Command;
import by.command.CommandResult;
import by.command.session.SessionAttribyte;
import by.exception.IncorrectDataException;
import by.exception.ServiceException;
import by.util.pages.Page;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingOutCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(SingOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute(SessionAttribyte.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribyte.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}
