package by.bsuir.wt.second.dao.api;

import by.bsuir.wt.second.dao.Dao;
import by.bsuir.wt.second.entity.UserInformation;
import by.bsuir.wt.second.exeptions.DaoException;


public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
