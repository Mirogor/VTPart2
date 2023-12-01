package by.bsuir.wt.second.service.api;

import by.bsuir.wt.second.entity.Role;
import by.bsuir.wt.second.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;

}
