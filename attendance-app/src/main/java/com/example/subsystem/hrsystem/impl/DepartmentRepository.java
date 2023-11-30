package subsystem.hrsystem.impl;

import mapper.impl.DepartmentMapper;
import model.Department;
import subsystem.AbstractRepository;
import subsystem.hrsystem.IDepartmentRepository;

import java.util.List;

public class DepartmentRepository extends AbstractRepository<Department> implements IDepartmentRepository {
    private static DepartmentRepository departmentRepository = null;

    public static DepartmentRepository getInstance() {
        if(departmentRepository == null) departmentRepository = new DepartmentRepository();

        return departmentRepository;
    }

    @Override
    public Department findByDepartmentId(Integer departmentId) {
        String sql = "SELECT * FROM department WHERE id = ?";

        List<Department> department = query(sql, DepartmentMapper.getInstance(), departmentId);

        return department.isEmpty() ? null : department.get(0);
    }
}
