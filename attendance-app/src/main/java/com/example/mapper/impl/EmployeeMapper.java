package mapper.impl;

import mapper.RowMapper;
import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    private static EmployeeMapper employeeMapper = null;
    @Override
    public Employee mapRow(ResultSet rs) throws SQLException {
        Employee employee = new Employee();

        try {
            employee.setId(rs.getInt("id"));
            employee.setEmployeeId(rs.getString("employee_id"));
            employee.setName(rs.getString("name"));
            employee.setGender(rs.getString("gender"));
            employee.setAge(rs.getInt("age"));
            employee.setDepartmentId(rs.getInt("department_id"));
            employee.setType(rs.getString("type"));

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static EmployeeMapper getInstance() {
        if(employeeMapper == null) employeeMapper = new EmployeeMapper();

        return employeeMapper;
    }
}
