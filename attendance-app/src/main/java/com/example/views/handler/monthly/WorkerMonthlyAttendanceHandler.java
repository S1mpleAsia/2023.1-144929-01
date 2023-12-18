package views.handler.monthly;

import dto.WorkerDataByDayDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import subsystem.timekeepingmachine.impl.RecordRepository;
import dto.TableDataDTO;
import usecase.detail.impl.WorkerDetailController;
import utils.Constraints;
import utils.Utils;
import utils.store.ContextFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class WorkerMonthlyAttendanceHandler extends MonthlyHandler implements Initializable {

    @FXML
    private AnchorPane date;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField departmentLabel;

    @FXML
    private TextField employeeNameLabel;

    @FXML
    public AnchorPane rootTimeTable;

    @FXML
    public Label workerName;

    @FXML
    public Label workerId;

    private WorkerDetailController monthlyAttendanceController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monthlyAttendanceController = new WorkerDetailController(RecordRepository.getInstance());
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");

        employeeNameLabel.setText(employeeInfo.getEmployeeName());
        workerName.setText("Worker:\n" + employeeInfo.getEmployeeName());
        workerId.setText("Mã NV:\n" + employeeInfo.getEmployeeId());

        departmentLabel.setText(employeeInfo.getDepartmentName());
        datePicker.setValue(LocalDate.now());

        System.out.println(LocalDate.of(2023, 12, 7));
        setTimeTableDate(datePicker.getValue(), rootTimeTable);

        initWeekAttendTime(employeeInfo.getEmployeeId(), getListColumn(rootTimeTable));
    }

    @FXML
    void handleBackScreen(MouseEvent event) throws IOException {
        navigate(Constraints.HOME_SCREEN_PATH, Constraints.HOME_STYLESHEET_PATH, event);
    }

    @FXML
    void handleExportFile(ActionEvent event) {

    }

    @FXML
    void onChooseDate(ActionEvent event) {
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");

        setTimeTableDate(datePicker.getValue(), rootTimeTable);
        initWeekAttendTime(employeeInfo.getEmployeeId(), getListColumn(rootTimeTable));
    }

    public void onChosenColumn(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
            Label header = (Label) anchorPane.getChildren().get(0);
            String headerText = header.getText();

            String dateString = headerText.split("\\n")[1];
            LocalDate localDate = Utils.simpleConvert(dateString);

            ContextFactory.getContext().putItem("date", localDate);
            displayView(Constraints.WORKER_DETAIL_SCREEN_PATH, Constraints.WORKER_DETAIL_STYLESHEET_PATH, mouseEvent);
        }
    }

    public void onFocusColumn(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();

        List<AnchorPane> listColumn = getListColumn(rootTimeTable);
        listColumn.remove(listColumn.size() - 1);
        listColumn.remove(listColumn.size() - 1);

        listColumn.forEach(column -> column.getStyleClass().remove("column-active"));

        anchorPane.getStyleClass().add("column-active");
    }

    @Override
    void initWeekAttendTime(String employeeId, List<AnchorPane> weekColumns) {
        weekColumns.remove(weekColumns.size() - 1);
        weekColumns.remove(weekColumns.size() - 1);

        weekColumns.forEach(column -> {
            ObservableList<Node> children = column.getChildren();
            Label columnDate = (Label) children.get(0);
            Label shift1 = (Label) children.get(1);
            Label shift2 = (Label) children.get(2);
            Label shift3 = (Label)  children.get(3);

            WorkerDataByDayDTO dataByDay = monthlyAttendanceController.getDataByDay(employeeId,
                    columnDate.getText().split("\\n")[1]);

            shift1.setText(dataByDay.getShift1().toString());
            shift2.setText(dataByDay.getShift2().toString());
            shift3.setText(dataByDay.getShift3().toString());
        });
    }
}
