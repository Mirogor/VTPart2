package by.bsuir.wt.second.service.impl;

import by.bsuir.wt.second.dao.DaoFactory;
import by.bsuir.wt.second.dao.impl.UserInformationDaoImpl;
import by.bsuir.wt.second.entity.User;
import by.bsuir.wt.second.entity.UserInformation;
import by.bsuir.wt.second.exeptions.DaoException;
import by.bsuir.wt.second.exeptions.ServiceException;
import by.bsuir.wt.second.service.api.UserInformationService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserInformationServiceImpl implements UserInformationService {


    @Override
    public Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException {
        try {
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            Optional<UserInformation> result;
            result = userInformationDao.findById(userInformationId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException {
        List<UserInformation> userInformation = new LinkedList<>();
        try {
            for (User user : users) {
                Optional<UserInformation> information = retrieveUserInformationById(user.getUserInformationId());
                if (information.isPresent()) {
                    if (!userInformation.contains(information.get())) {
                        userInformation.add(information.get());
                    }
                }
            }
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return userInformation;
    }
}
