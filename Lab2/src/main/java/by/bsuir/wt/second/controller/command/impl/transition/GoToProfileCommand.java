package by.bsuir.wt.second.controller.command.impl.transition;

import by.bsuir.wt.second.controller.command.Command;
import by.bsuir.wt.second.controller.command.CommandResult;
import by.bsuir.wt.second.controller.command.CommandResultType;
import by.bsuir.wt.second.controller.context.RequestContext;
import by.bsuir.wt.second.controller.context.RequestContextHelper;
import by.bsuir.wt.second.entity.User;
import by.bsuir.wt.second.entity.UserInformation;
import by.bsuir.wt.second.exeptions.ServiceException;
import by.bsuir.wt.second.service.ServiceFactory;
import by.bsuir.wt.second.service.api.UserInformationService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class GoToProfileCommand implements Command {
    private static final String PAGE = "WEB-INF/view/profile.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER = "user";
    private static final String USER_INFORMATION = "userInformation";


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }

        try {


            int userInformationId = user.getUserInformationId();
            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();

            Optional<UserInformation> userInformation = userInformationService.retrieveUserInformationById(userInformationId);
            userInformation.ifPresent(information -> requestContext.addRequestAttribute(USER_INFORMATION, information));
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
