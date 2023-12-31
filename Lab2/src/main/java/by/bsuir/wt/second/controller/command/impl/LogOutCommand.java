package by.bsuir.wt.second.controller.command.impl;

import by.bsuir.wt.second.controller.command.Command;
import by.bsuir.wt.second.controller.command.CommandResult;
import by.bsuir.wt.second.controller.command.CommandResultType;
import by.bsuir.wt.second.controller.context.RequestContext;
import by.bsuir.wt.second.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements Command {
    private static final String LOGIN_PAGE = "command=logIn";
    private static final String USER = "user";
    private static final String ROLE = "role";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        requestContext.removeSessionAttribute(USER);
        requestContext.removeSessionAttribute(ROLE);
        helper.updateRequest(requestContext);
        return new CommandResult(LOGIN_PAGE, CommandResultType.REDIRECT);
    }
}