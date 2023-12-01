package mapper.impl;

import mapper.RowMapper;
import model.Account;
import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {
    private static DepartmentMapper departmentMapper = null;
    @Override
    public Department mapRow(ResultSet rs) throws SQLException {
        Department department = new Department();

        try {
            department.setId(rs.getInt("id"));
            department.setManagerId(rs.getInt("manager_id"));
            department.setDepartmentName(rs.getString("department_name"));

            return department;
        } catch (SQLException e) {
            e.printStackTrace();;
        }

        return null;
    }

    public static DepartmentMapper getInstance() {
        if(departmentMapper == null) departmentMapper = new DepartmentMapper();

        return departmentMapper;
    }
}
