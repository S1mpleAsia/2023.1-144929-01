package usecase.officer_home.iml;

import model.Employee;
import subsystem.hrsystem.IEmployeeRepository;
import usecase.officer_home.IOfficerHomeController;

public class OfficerHomeController implements IOfficerHomeController {
    private final IEmployeeRepository employeeRepository;

    public OfficerHomeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee getOfficerInfoById(Integer id) {
        Employee employee = employeeRepository.getEmployeeInfoById(id);
        return employee;
    }
}
