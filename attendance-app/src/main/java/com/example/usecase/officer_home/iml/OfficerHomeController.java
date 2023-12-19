package usecase.officer_home.iml;

import dto.EmployeeDTO;
import model.Employee;
import subsystem.hrsystem.IEmployeeRepository;
import usecase.login.impl.LoginController;
import usecase.officer_home.IOfficerHomeController;
import utils.store.ApplicationContext;
import utils.store.ContextFactory;

public class OfficerHomeController implements IOfficerHomeController {
    private final IEmployeeRepository employeeRepository;
    private Integer employeeId;

    public OfficerHomeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public OfficerHomeController(IEmployeeRepository employeeRepository, Integer employeeId) {
        this.employeeRepository = employeeRepository;
        this.employeeId = employeeId;
    }


    @Override
    public EmployeeDTO getOfficerInfoById(Integer id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = employeeRepository.getEmployeeInfoById(id);
        if(employee != null) {
            employeeDTO.setName(employee.getName());
            employeeDTO.setEmployeeId(employee.getEmployeeId());
            employeeDTO.setDepartmentId(employee.getDepartmentId());
            return employeeDTO;
        }
        else return null;

    }
}
