package by.bsuir.wt.second.dao.mapper;

import by.bsuir.wt.second.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {
    T map(ResultSet resultSet) throws SQLException;
}