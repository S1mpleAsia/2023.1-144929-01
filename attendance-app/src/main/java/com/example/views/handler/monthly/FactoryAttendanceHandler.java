package views.handler.monthly;

import dto.FactoryAttendanceDTO;
import enums.Shift;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Account;
import model.Department;
import model.Employee;
import subsystem.hrsystem.IDepartmentRepository;
import subsystem.hrsystem.IEmployeeRepository;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import subsystem.timekeepingmachine.impl.RecordRepository;
import usecase.factory_attendance.impl.FactoryAttendanceController;
import utils.Constraints;
import utils.store.ContextFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FactoryAttendanceHandler extends MonthlyHandler implements Initializable {
    @FXML
    public TextField departmentLabel;
    @FXML
    public AnchorPane rootTimeTable;
    @FXML
    public DatePicker datePicker;
    @FXML
    public AnchorPane date;
    @FXML
    public TreeTableView<FactoryAttendanceDTO> factoryTreeTable;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> worker;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, Shift> shift;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> monday;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> tuesday;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> wednesday;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> thursday;
    @FXML
    public TreeTableColumn<FactoryAttendanceDTO, String> friday;

    private final FactoryAttendanceController factoryAttendanceController = new FactoryAttendanceController(RecordRepository.getInstance());

    private final Employee currentUser = (Employee) ContextFactory.getContext().getItem("currentUser");
    private final Department department = DepartmentRepository.getInstance().findByDepartmentId(currentUser.getDepartmentId());

    private final List<Employee> employeeList = EmployeeRepository.getInstance().findAllByDepartmentId(department.getId());
    public List<String> getEmployeeNames() {
        List<String> employeeNames = new ArrayList<>();

        for (Employee emp: employeeList) {
            employeeNames.add(emp.getName());
        }

        return employeeNames;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentLabel.setText(department.getDepartmentName());
        datePicker.setValue(LocalDate.now());

        ObservableList<FactoryAttendanceDTO> factoryAttendanceTableData = factoryAttendanceController.getFactoryAttendanceTableData(department.getId(), datePicker.getValue());

        initFactoryWeekAttendTime(getEmployeeNames(), factoryAttendanceTableData, factoryTreeTable);

    }

    public void initFactoryWeekAttendTime(List<String> employeeNames ,ObservableList<FactoryAttendanceDTO> factoryAttendanceDTOS, TreeTableView<FactoryAttendanceDTO> factoryTreeTable) {
        TreeItem<FactoryAttendanceDTO> factoryAttendanceTreeItem = createFactoryAttendanceTreeItem(employeeNames, factoryAttendanceDTOS);

        worker.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        shift.setCellValueFactory(param -> param.getValue().getValue().shiftProperty());
        monday.setCellValueFactory(param -> param.getValue().getValue().mondayTimeProperty().asString());
        tuesday.setCellValueFactory(param -> param.getValue().getValue().tuesdayTimeProperty().asString());
        wednesday.setCellValueFactory(param -> param.getValue().getValue().wednesdayTimeProperty().asString());
        thursday.setCellValueFactory(param -> param.getValue().getValue().thursdayTimeProperty().asString());
        friday.setCellValueFactory(param -> param.getValue().getValue().fridayTimeProperty().asString());

        factoryTreeTable.setRoot(factoryAttendanceTreeItem);
        factoryTreeTable.setShowRoot(false);
    }

    public TreeItem<FactoryAttendanceDTO> createFactoryAttendanceTreeItem(List<String> employeeNames, ObservableList<FactoryAttendanceDTO> factoryAttendanceDTOS) {
        TreeItem<FactoryAttendanceDTO> root = new TreeItem<>(new FactoryAttendanceDTO("No worker",
                null, 0.0, 0.0, 0.0, 0.0, 0.0));
        root.setExpanded(true);

        employeeNames.stream().sorted().forEach(employeeName -> {
            TreeItem<FactoryAttendanceDTO> employeeTitleItem = new TreeItem<>(new FactoryAttendanceDTO(employeeName, null,
                    0.0, 0.0, 0.0, 0.0, 0.0));

            root.getChildren().add(employeeTitleItem);
            employeeTitleItem.setExpanded(true);

            factoryAttendanceDTOS.stream()
                    .sorted().filter(factoryAttendance -> employeeName.contentEquals(factoryAttendance.getName()))
                    .forEach(factoryAttendance -> {
                        TreeItem<FactoryAttendanceDTO> factoryAttendanceLineItem = new TreeItem<>(
                                new FactoryAttendanceDTO(null, factoryAttendance.getShift(),
                                        factoryAttendance.getMondayTime(),factoryAttendance.getTuesdayTime(),
                                        factoryAttendance.getWednesdayTime(), factoryAttendance.getThursdayTime(), factoryAttendance.getFridayTime())
                        );
                        employeeTitleItem.getChildren().add(factoryAttendanceLineItem);
                    });
        });

        return root;
    }

    @Override
    void initWeekAttendTime(String employeeId, List<AnchorPane> weekColumns) {


    }
    @FXML
    public void handleBackScreen(MouseEvent event) throws IOException {
        navigate(Constraints.HOME_SCREEN_PATH, Constraints.HOME_STYLESHEET_PATH, event);
    }
    @FXML
    public void onChooseDate(ActionEvent actionEvent) {
        ObservableList<FactoryAttendanceDTO> factoryAttendanceTableData = factoryAttendanceController.getFactoryAttendanceTableData(department.getId(), datePicker.getValue());

        initFactoryWeekAttendTime(getEmployeeNames(), factoryAttendanceTableData, factoryTreeTable);
    }

    public void handleExportFile(ActionEvent actionEvent) {
    }
}
