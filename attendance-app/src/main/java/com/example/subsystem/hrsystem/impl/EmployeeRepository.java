package subsystem.hrsystem.impl;

import mapper.impl.EmployeeMapper;
import model.Employee;
import subsystem.AbstractRepository;
import subsystem.hrsystem.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository extends AbstractRepository<Employee> implements IEmployeeRepository {
    private static EmployeeRepository employeeRepository = null;

    public static EmployeeRepository getInstance() {
        if(employeeRepository == null) employeeRepository = new EmployeeRepository();

        return employeeRepository;
    }
    @Override
    public List<Employee> findAllByDepartmentId(Integer departmentId) {
        String sql = "SELECT * FROM employee WHERE department_id = ?";

        List<Employee> employeeList = query(sql, EmployeeMapper.getInstance(), departmentId);
        return employeeList.isEmpty() ? null : employeeList;
    }

    @Override
    public Employee getEmployeeInfoById(Integer id) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        List<Employee> employeeList = query(sql, EmployeeMapper.getInstance(), id);
        if (employeeList == null || employeeList.isEmpty()) {
            return null;
        }
        return employeeList.get(0);
    }


}
