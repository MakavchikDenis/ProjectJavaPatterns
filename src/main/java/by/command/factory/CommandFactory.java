package by.command.factory;

import by.command.Command;
import by.command.LoginPageCommand;
import by.command.RegisterPageCommand;
import by.command.authorithation.LoginCommand;
import by.command.authorithation.RegisterNewUserCommand;
import by.command.authorithation.SingOutCommand;
import by.command.grouppersons.AddNewPersonCommand;
import by.command.grouppersons.WelcomeCommand;


public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
            case LOGIN: {
                resultCommand = new LoginCommand();
                break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand();
                break;
            }
            case SIGN_OUT: {
                resultCommand = new SingOutCommand();
                break;
            }
            case ADD_NEW_PERSON:{
                resultCommand = new AddNewPersonCommand();
                break;
            }
            case LOGIN_PAGE:{
                resultCommand = new LoginPageCommand();
                break;
            }
            case WELCOME:{
                resultCommand = new WelcomeCommand();
                break;
            }
            case REGISTRATION_PAGE:{
                resultCommand = new RegisterPageCommand();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid command" +
                        commandEnum);
            }
        }
        return resultCommand;
    }
}
