package usecase.officer_home;

import dto.EmployeeDTO;
import model.Employee;

public interface IOfficerHomeController {
    EmployeeDTO getOfficerInfoById(Integer id);
}
