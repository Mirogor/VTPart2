package by.bsuir.wt.second.dao.mapper.impl;

import by.bsuir.wt.second.dao.mapper.Column;
import by.bsuir.wt.second.dao.mapper.RowMapper;
import by.bsuir.wt.second.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt(Column.ID));
        role.setName(resultSet.getString(Column.ROLE_NAME));
        return role;
    }
}