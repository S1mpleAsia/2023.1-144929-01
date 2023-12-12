package views.handler.detail;

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
import usecase.detail.impl.WorkerMonthlyAttendanceController;
import utils.Constraints;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MonthlyAttendanceHandler extends BaseHandler implements Initializable {

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

    private WorkerMonthlyAttendanceController monthlyAttendanceController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monthlyAttendanceController = new WorkerMonthlyAttendanceController(RecordRepository.getInstance());
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");

        employeeNameLabel.setText(employeeInfo.getEmployeeName());
        workerName.setText("Worker:\n" + employeeInfo.getEmployeeName());
        workerId.setText("Mã NV:\n" + employeeInfo.getEmployeeId());

        departmentLabel.setText(employeeInfo.getDepartmentName());
        datePicker.setValue(LocalDate.now());

        System.out.println(LocalDate.of(2023, 12, 7));
        setTimeTableDate(datePicker.getValue());
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
        setTimeTableDate(datePicker.getValue());
    }

    public void onChosenColumn(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            ContextFactory.getContext().putItem("date", datePicker.getValue());
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

    private List<AnchorPane> getListColumn(AnchorPane rootTimeTable) {
        List<AnchorPane> list = new ArrayList<>();

        ObservableList<Node> children = rootTimeTable.getChildren();

        for (Node child : children) {
            if (child instanceof AnchorPane) list.add((AnchorPane) child);
        }

        list.remove(0);
        list.remove(0);

        return list;
    }

    private void setTimeTableDate(LocalDate currentDate) {
        List<AnchorPane> list = getListColumn(rootTimeTable);

        int currentIndex = currentDate.getDayOfWeek().getValue(); // Mon-1 Sun-7

        List<String> weeksLabel = new ArrayList<>();
        for(DayOfWeek day : DayOfWeek.values()) {
            String dayName = day.name();

            String firstLetter = dayName.substring(0, 1).toUpperCase();
            String remainingLetter = dayName.substring(1).toLowerCase();

            String capitalizedDay = firstLetter  + remainingLetter;
            weeksLabel.add(capitalizedDay);
        }

        List<LocalDate> weekDates = new ArrayList<>();

        for(int i = 0;i < 7; i++) {
            LocalDate tempDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());
            weekDates.add(tempDate.minusDays(currentIndex - i - 1));
        }


        List<String> weekLabelsAndDates = new ArrayList<>();
        for(int i = 0;i < 7; i++) {
            weekLabelsAndDates.add(weeksLabel.get(i) + "\n" + weekDates.get(i));
        }

        for(AnchorPane column : list) {
            int index = list.indexOf(column);

            if(index != currentIndex - 1) column.getStyleClass().remove("column-active");
            else column.getStyleClass().add("column-active");

            Node firstNode = column.getChildren().get(0);

                if(firstNode instanceof Label label) {
                    label.setText(weekLabelsAndDates.get(index));
                }
        }
    }
}
