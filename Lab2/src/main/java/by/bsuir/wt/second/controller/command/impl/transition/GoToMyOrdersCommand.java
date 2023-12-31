package by.bsuir.wt.second.controller.command.impl.transition;

import by.bsuir.wt.second.controller.command.Command;
import by.bsuir.wt.second.controller.command.CommandResult;
import by.bsuir.wt.second.controller.command.CommandResultType;
import by.bsuir.wt.second.controller.context.RequestContext;
import by.bsuir.wt.second.controller.context.RequestContextHelper;
import by.bsuir.wt.second.entity.Apartment;
import by.bsuir.wt.second.entity.User;
import by.bsuir.wt.second.entity.UserOrder;
import by.bsuir.wt.second.exeptions.ServiceException;
import by.bsuir.wt.second.service.ServiceFactory;
import by.bsuir.wt.second.service.api.ApartmentService;
import by.bsuir.wt.second.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToMyOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/myOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String APARTMENTS = "apartments";
    private static final String USER = "user";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }
        try {
            UserOrderService userOrderService=ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders=userOrderService.retrieveUserOrderByUserId(user.getId());
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);
            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserId(user.getId());
            requestContext.addRequestAttribute(APARTMENTS, apartments);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
