package usecase.officer_home;

import dto.EmployeeDTO;
import dto.TableDataDTO;
import model.Employee;

public interface IOfficerHomeController {
    TableDataDTO getOfficerInfoById(Integer id);
}
