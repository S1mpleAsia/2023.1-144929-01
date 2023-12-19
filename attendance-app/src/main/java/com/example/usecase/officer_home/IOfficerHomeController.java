package usecase.officer_home;

import model.Employee;

public interface IOfficerHomeController {
    Employee getOfficerInfoById(Integer id);
}
