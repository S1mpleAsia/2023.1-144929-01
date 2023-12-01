package subsystem.hrsystem;

import model.Department;
import subsystem.GenericRepository;

public interface IDepartmentRepository extends GenericRepository<Department> {
    Department findByDepartmentId(Integer departmentId);
}
