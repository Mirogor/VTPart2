package by.bsuir.wt.second.dao.api;

import by.bsuir.wt.second.dao.Dao;
import by.bsuir.wt.second.entity.User;
import by.bsuir.wt.second.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {


    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;


    Optional<User> findByEmail(String email) throws DaoException;
}
