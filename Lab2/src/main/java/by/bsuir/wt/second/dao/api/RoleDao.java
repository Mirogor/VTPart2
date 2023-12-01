package by.bsuir.wt.second.dao.api;

import by.bsuir.wt.second.dao.Dao;
import by.bsuir.wt.second.entity.Role;
import by.bsuir.wt.second.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {


    Optional<Role> findByName(String name) throws DaoException;
}