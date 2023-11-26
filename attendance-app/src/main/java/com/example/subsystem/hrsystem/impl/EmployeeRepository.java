package subsystem.hrsystem.impl;

import model.Employee;
import subsystem.AbstractRepository;
import subsystem.hrsystem.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository extends AbstractRepository<Employee> implements IEmployeeRepository {
    public static EmployeeRepository employeeRepository = null;

    public static EmployeeRepository getInstance() {
        if(employeeRepository == null) employeeRepository = new EmployeeRepository();

        return employeeRepository;
    }
    @Override
    public List<Employee> findAllByDepartment(String department) {
        String sql = "SELECT * FROM employee WHERE deparment = ?";

//        List<Employee> employeeList = query(sql, )
        return null;
    }
}
