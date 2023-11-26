package mapper.impl;

import mapper.RowMapper;
import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs) throws SQLException {

        return null;
    }
}
