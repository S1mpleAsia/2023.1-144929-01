package subsystem.hrsystem;

import model.Employee;
import subsystem.GenericRepository;

import java.util.List;

public interface IEmployeeRepository extends GenericRepository<Employee> {
    List<Employee> findAllByDepartmentId(Integer departmentId);
}
