package by.bsuir.wt.second.dao.impl;

import by.bsuir.wt.second.dao.api.RoleDao;
import by.bsuir.wt.second.dao.mapper.RowMapperFactory;
import by.bsuir.wt.second.dao.AbstractDao;
import by.bsuir.wt.second.dao.Table;
import by.bsuir.wt.second.entity.Role;
import by.bsuir.wt.second.exeptions.DaoException;

import java.util.Optional;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    private static final String SAVE_ROLE_QUERY = "INSERT INTO " + Table.ROLE + " (role) VALUES (?)";
    private static final String FIND_ROLE_BY_NAME_QUERY = "SELECT * FROM " + Table.ROLE + " WHERE role=?";

    public RoleDaoImpl() {
        super(RowMapperFactory.getInstance().getRoleRowMapper(), Table.ROLE);
    }

    @Override
    public int save(Role role) throws DaoException {
        return executeInsertQuery(SAVE_ROLE_QUERY, role.getName());
    }

    @Override
    public Optional<Role> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME_QUERY, name);
    }
}
