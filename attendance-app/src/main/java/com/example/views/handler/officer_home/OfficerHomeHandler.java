package views.handler.officer_home;

import dto.EmployeeDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Employee;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.login.ILoginController;
import usecase.officer_home.IOfficerHomeController;
import usecase.officer_home.iml.OfficerHomeController;
import utils.Utils;
import utils.store.ContextFactory;
import views.handler.BaseHandler;
import views.handler.login.LoginHandler;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class OfficerHomeHandler extends BaseHandler implements Initializable {
    public static Logger LOGGER = Utils.getLogger(LoginHandler.class.getName());

    private Integer employeeId;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField employeeIdLabel;

    @FXML
    private TextField departmentIdLabel;


    private IOfficerHomeController officerHomeController;
    private ILoginController loginController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeController() {
        officerHomeController = new OfficerHomeController(EmployeeRepository.getInstance());
        Integer employeeId = (Integer) ContextFactory.getContext().getItem("userEmployeeId");
        // set giá trị của text
        EmployeeDTO employeeDTO = officerHomeController.getOfficerInfoById(employeeId);
        LOGGER.info(employeeDTO.toString());
        if (employeeDTO != null){
            nameLabel.setText(employeeDTO.getName());
            departmentIdLabel.setText(employeeDTO.getDepartmentId().toString());
            employeeIdLabel.setText(employeeDTO.getEmployeeId());
        }else{
            nameLabel.setText("no information");
            departmentIdLabel.setText("no information");
            employeeIdLabel.setText("no information");
        }
    }
}