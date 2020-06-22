package by.command.authorithation;


import by.command.Command;
import by.command.CommandResult;
import by.command.session.SessionAttribyte;
import by.exception.IncorrectDataException;
import by.exception.ServiceException;
import by.model.UserNew;
import by.service.UserService;
import by.util.HashPassword;
import by.util.pages.Page;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import static by.command.authorithation.constants.AuthConstants.*;
import static java.util.Optional.of;
import java.lang.Object;

import static org.apache.commons.lang3.StringUtils.isEmpty;


public class LoginCommand implements Command{
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());
    private void setAttributesToSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribyte.NAME, name);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException, ServletException,
            IOException {
        boolean isUserFind = false;
        Optional<String> login = of(request).map(httpServletRequest ->
                        httpServletRequest.getParameter(LOGIN));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD));
        if (isEmpty(login.get()) || isEmpty(password.get())) {
            return forwardLoginWithError(request, ERROR_MESSAGE,
                    ERROR_MESSAGE_TEXT);
        }
        byte[] pass = HashPassword.getHash(password.get());
        isUserFind = initializeUserIfExist(login.get(), pass, request);
        if (!isUserFind) {
            LOGGER.info("user with such login and password doesn't exist");
            return forwardLoginWithError(request, ERROR_MESSAGE, AUTHENTICATION_ERROR_TEXT);
        } else {
            LOGGER.info("user has been authorized: login:" + login + " password:"
                    + password);
            return new CommandResult(COMMAND_WELCOME, false);
        }
    }
    public boolean initializeUserIfExist(String login, byte[] password,
                                         HttpServletRequest request) throws ServiceException {
        UserService userService = new UserService();
        Optional<UserNew> user = userService.login(login, password);
        boolean userExist = false;
        if (user.isPresent()) {
            setAttributesToSession(user.get().getLogin(), request);
            userExist = true;
        }
        return userExist;
    }
    private CommandResult forwardLoginWithError(HttpServletRequest request, final String ERROR,
                                                final String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}
