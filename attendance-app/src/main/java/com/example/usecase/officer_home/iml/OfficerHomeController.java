package usecase.officer_home.iml;

import dto.TableDataDTO;
import model.Department;
import model.Employee;
import subsystem.hrsystem.IDepartmentRepository;
import subsystem.hrsystem.IEmployeeRepository;
import usecase.officer_home.IOfficerHomeController;

public class OfficerHomeController implements IOfficerHomeController {
    private final IEmployeeRepository employeeRepository;
    private final IDepartmentRepository departmentRepository;
    private Integer employeeId;

    public OfficerHomeController(IEmployeeRepository employeeRepository, IDepartmentRepository departmentRepository ) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    public OfficerHomeController(IEmployeeRepository employeeRepository, IDepartmentRepository departmentRepository, Integer employeeId) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeId = employeeId;
    }


    @Override
    public TableDataDTO getOfficerInfoById(Integer id) {
        TableDataDTO tableDataDTO = new TableDataDTO();
        Employee employee = employeeRepository.getEmployeeInfoById(id);
        Department department = departmentRepository.findByDepartmentId(employee.getDepartmentId());

        tableDataDTO.setEmployeeName(employee.getName());
        tableDataDTO.setEmployeeId(employee.getEmployeeId());
        tableDataDTO.setDepartmentName(department.getDepartmentName());
        tableDataDTO.setEmployeeType(employee.getType());
        tableDataDTO.setAge(employee.getAge());
        tableDataDTO.setGender(employee.getGender());
        return tableDataDTO;

    }
}
