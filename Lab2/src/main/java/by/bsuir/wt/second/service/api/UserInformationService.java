package by.bsuir.wt.second.service.api;

import by.bsuir.wt.second.entity.User;
import by.bsuir.wt.second.entity.UserInformation;
import by.bsuir.wt.second.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
