package by.bsuir.wt.second.service.api;

import by.bsuir.wt.second.entity.UserOrder;
import by.bsuir.wt.second.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserOrderService {

    Optional<UserOrder> retrieveUserOrderById(int userOrderId) throws ServiceException;

    List<UserOrder> retrieveUserOrderByUserId(int userId) throws ServiceException;


    List<UserOrder> retrieveUserOrderByStatus(String status) throws ServiceException;


    boolean updateStatusAtUserOrderById(int userOrderId, String status) throws ServiceException;


    boolean addNewUserOrder(String stringYear,String stringMonth,String stringDay,String stringHours,
                            String stringMinutes, String stringLeaseDuration,String stringUserId,String stringApartmentId) throws ServiceException;

}
