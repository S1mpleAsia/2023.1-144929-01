package views.handler.officer_home;

import dto.EmployeeDTO;
import dto.TableDataDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Employee;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.login.ILoginController;
import usecase.officer_home.IOfficerHomeController;
import usecase.officer_home.iml.OfficerHomeController;
import utils.Constraints;
import utils.Utils;
import utils.store.ContextFactory;
import views.handler.BaseHandler;
import views.handler.login.LoginHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class OfficerHomeHandler extends BaseHandler implements Initializable {
    public static Logger LOGGER = Utils.getLogger(LoginHandler.class.getName());


    @FXML
    public AnchorPane content;

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
        officerHomeController = new OfficerHomeController(EmployeeRepository.getInstance(), DepartmentRepository.getInstance());
        Integer employeeId = (Integer) ContextFactory.getContext().getItem("userEmployeeId");
        TableDataDTO tableDataDTO = officerHomeController.getOfficerInfoById(employeeId);
        nameLabel.setText(tableDataDTO.getEmployeeName());
        departmentIdLabel.setText(tableDataDTO.getDepartmentName());
        employeeIdLabel.setText(tableDataDTO.getEmployeeId());
    }
    @FXML
    private void openMonthlyAttendanceTable(MouseEvent event) throws IOException {
        officerHomeController = new OfficerHomeController(EmployeeRepository.getInstance(), DepartmentRepository.getInstance());
        Integer employeeId = (Integer) ContextFactory.getContext().getItem("userEmployeeId");
        TableDataDTO tableDataDTO = officerHomeController.getOfficerInfoById(employeeId);
        ContextFactory.getContext().putItem("employeeInfo", tableDataDTO);

        changeContentView(Constraints.OFFICER_MONTHLY_TABLE_SCREEN_PATH, content);
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws IOException {
        clearSession(); // Clear user session data
        navigate(Constraints.LOGIN_SCREEN_PATH, Constraints.LOGIN_STYLESHEET_PATH, actionEvent);
    }

    private void clearSession() {
        ContextFactory.getContext().emptyState();
    }
}