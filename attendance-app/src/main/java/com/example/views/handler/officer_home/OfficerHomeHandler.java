package views.handler.officer_home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Employee;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.officer_home.IOfficerHomeController;
import usecase.officer_home.iml.OfficerHomeController;
import views.handler.BaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class OfficerHomeHandler extends BaseHandler implements Initializable {

    private Integer employeeId;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField employeeIdLabel;

    @FXML
    private TextField departmentIdLabel;

    private EmployeeRepository employeeRepository;

    private IOfficerHomeController officerHomeController;

    public OfficerHomeHandler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeController() {
        officerHomeController = new OfficerHomeController(employeeRepository);

        if (employeeId != null) {
            Employee employee = officerHomeController.getOfficerInfoById(employeeId);

            if (employee != null) {
                nameLabel.setText(employee.getName());
                employeeIdLabel.setText(employee.getEmployeeId().toString());
                departmentIdLabel.setText(employee.getDepartmentId().toString());
            } else {
                nameLabel.setText("Không tìm thấy nhân viên");
                employeeIdLabel.setText("");
                departmentIdLabel.setText("");
            }
        } else {
            // Handle the case where employeeId is not set
            nameLabel.setText("Employee ID not set");
            employeeIdLabel.setText("");
            departmentIdLabel.setText("");
        }
    }
}