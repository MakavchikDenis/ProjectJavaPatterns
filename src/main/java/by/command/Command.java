package by.command;

import by.exception.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


    public interface Command {
        CommandResult execute(HttpServletRequest request, HttpServletResponse response)
                throws ServiceException, IncorrectDataException, ServletException, IOException;
    }

