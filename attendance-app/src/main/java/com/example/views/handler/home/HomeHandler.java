package views.handler.home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Account;
import model.Employee;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.home.impl.HomeController;
import usecase.home.IHomeController;
import dto.TableDataDTO;
import utils.Constraints;
import utils.EmployeeType;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeHandler extends BaseHandler implements Initializable {
    @FXML
    private TableColumn<?, ?> age;

    @FXML
    private AnchorPane content;

    @FXML
    private TableColumn<?, ?> deparment;

    @FXML
    private TextField departmentLabel;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableView<TableDataDTO> table;

    @FXML
    private TableColumn<?, ?> employeeType;

    @FXML
    private TextField searchField;

    private IHomeController homeController;

    private final ObservableList<TableDataDTO> tableData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeController = new HomeController(EmployeeRepository.getInstance(), DepartmentRepository.getInstance());
        Employee currentUser = (Employee) ContextFactory.getContext().getItem("currentUser");
        Integer departmentId = currentUser.getDepartmentId();
        tableData.clear();
        tableData.addAll(homeController.getTableData(departmentId));


        id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        deparment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        employeeType.setCellValueFactory(new PropertyValueFactory<>("employeeType"));

        table.setItems(tableData);
    }


    @FXML
    void handleViewOverview(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            TableDataDTO selectedItem = table.getSelectionModel().getSelectedItem();

            ContextFactory.getContext().putItem("employeeInfo", selectedItem);

            if (selectedItem.getEmployeeType().toUpperCase().equals(EmployeeType.WORKER.name())) {
                changeContentView(Constraints.WORKER_MONTHLY_SCREEN_PATH, content);
            } else if (selectedItem.getEmployeeType().toUpperCase().equals(EmployeeType.OFFICER.name())) {
                changeContentView(Constraints.OFFICER_MONTHLY_SCREEN_PATH, content);
            }

        }
    }

    @FXML
    void handleDepartmentAttendanceView(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
            Account currentUser = (Account) ContextFactory.getContext().getItem("currentAccount");

            if (currentUser.getRole().toUpperCase().equals(EmployeeType.MANAGER.name())) {
                changeContentView(Constraints.FACTORY_ATTENDANCE_SCREEN_PATH, content);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bạn không có quyền này");
                alert.setHeaderText("Lỗi");
                alert.showAndWait();
            }

        }
    }

}
