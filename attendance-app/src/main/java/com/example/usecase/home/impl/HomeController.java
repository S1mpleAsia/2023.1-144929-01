package usecase.home.impl;

import model.Department;
import model.Employee;
import subsystem.hrsystem.IDepartmentRepository;
import subsystem.hrsystem.IEmployeeRepository;
import dto.TableDataDTO;
import usecase.home.IHomeController;
import utils.store.ContextFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeController implements IHomeController {
    private final IEmployeeRepository employeeRepository;
    private final IDepartmentRepository departmentRepository;

    public HomeController(IEmployeeRepository employeeRepository, IDepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        ContextFactory.getContext().putItem("currentUser", employeeRepository.getEmployeeInfoById((Integer) ContextFactory.getContext().getItem("userEmployeeId")));
    }

    @Override
    public List<TableDataDTO> getTableData(Integer departmentId) {
        Department department = departmentRepository.findByDepartmentId(departmentId);

        if(department == null) throw new RuntimeException("No department found");

        List<Employee> employeeList = employeeRepository.findAllByDepartmentId(departmentId);

        List<TableDataDTO> tableData = new ArrayList<>(Collections.emptyList());

        employeeList.forEach(employee -> {
            TableDataDTO tableDataDTO  = new TableDataDTO();

            tableDataDTO.setDepartmentName(department.getDepartmentName());
            tableDataDTO.setGender(employee.getGender());
            tableDataDTO.setAge(employee.getAge());
            tableDataDTO.setEmployeeId(employee.getEmployeeId());
            tableDataDTO.setEmployeeName(employee.getName());
            tableDataDTO.setEmployeeType(employee.getType());

            tableData.add(tableDataDTO);
        });

        return tableData;
    }
}
