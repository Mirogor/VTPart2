package by.bsuir.wt.second.service.impl;

import by.bsuir.wt.second.dao.DaoFactory;
import by.bsuir.wt.second.dao.api.RoleDao;
import by.bsuir.wt.second.entity.Role;
import by.bsuir.wt.second.exeptions.DaoException;
import by.bsuir.wt.second.exeptions.ServiceException;
import by.bsuir.wt.second.service.api.RoleService;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {




    @Override
    public Optional<Role> retrieveRoleById(int roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findByName(roleName);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }
}