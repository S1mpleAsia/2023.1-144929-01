package views.handler.monthly;

import dto.OfficerDataByDayDTO;
import dto.TableDataDTO;
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
import usecase.detail.IDetailController;
import usecase.detail.impl.OfficerAttendController;
import utils.Constraints;
import utils.Utils;
import utils.store.ContextFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class OfficerMonthlyAttendanceHandler extends MonthlyHandler implements Initializable {

    @FXML
    private Label afternoonSessionLabel;

    @FXML
    private AnchorPane date;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField departmentLabel;

    @FXML
    private Label earlyLeaveLabel;

    @FXML
    private TextField employeeNameLabel;

    @FXML
    private Label hourLateLabel;

    @FXML
    private Label morningSessionLabel;

    @FXML
    private AnchorPane rootTimeTable;

    @FXML
    private Label officerId;

    @FXML
    private Label officerName;

    private IDetailController<OfficerDataByDayDTO> officerDetailController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        officerDetailController = new OfficerAttendController(RecordRepository.getInstance());

        morningSessionLabel.setText("Sáng\n" + "(morningSession)");
        afternoonSessionLabel.setText("Chiều\n" + "(afternoonSession)");
        hourLateLabel.setText("Đi muộn\n" + "(hoursLate)");
        earlyLeaveLabel.setText("Về sớm\n" + "hoursEarlyLeave");

        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");

        employeeNameLabel.setText(employeeInfo.getEmployeeName());
        officerName.setText("Officer:\n" + employeeInfo.getEmployeeName());
        officerId.setText("Mã NV:\n" + employeeInfo.getEmployeeId());

        departmentLabel.setText(employeeInfo.getDepartmentName());
        datePicker.setValue(LocalDate.now());
        setTimeTableDate(datePicker.getValue(), rootTimeTable);

        initHoverColumn();
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

    @FXML
    void onChosenColumn(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
            Label header = (Label) anchorPane.getChildren().get(0);
            String headerText = header.getText();

            String dateString = headerText.split("\\n")[1];
            System.out.println(datePicker.getValue());
            LocalDate localDate = Utils.simpleConvert(dateString);

            ContextFactory.getContext().putItem("date", localDate);
            displayView(Constraints.OFFICER_DETAIL_SCREEN_PATH, Constraints.OFFICER_DETAIL_STYLESHEET_PATH, mouseEvent);
        }
    }

    @FXML
    void onFocusColumn(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();

        List<AnchorPane> listColumn = getListColumn(rootTimeTable);
        listColumn.remove(listColumn.size() - 1);
        listColumn.remove(listColumn.size() - 1);

        listColumn.forEach(column -> column.getStyleClass().remove("column-active"));

        anchorPane.getStyleClass().add("column-active");
    }

    private void initHoverColumn() {
        List<AnchorPane> listColumn = getListColumn(rootTimeTable);
        listColumn.remove(listColumn.size() - 1);
        listColumn.remove(listColumn.size() - 1);

        listColumn.forEach(column -> {
            column.getStyleClass().add("base-column");
            Label firstLabel = (Label) column.getChildren().get(1);
            Label secondLabel = (Label) column.getChildren().get(2);
            Label thirdLabel = (Label) column.getChildren().get(3);
            Label forthLabel = (Label) column.getChildren().get(4);


            firstLabel.getStyleClass().add("base-label");
            secondLabel.getStyleClass().add("base-label");
            thirdLabel.getStyleClass().add("base-label");
            forthLabel.getStyleClass().add("base-label");
        });
    }

    @Override
    void initWeekAttendTime(String employeeId, List<AnchorPane> weekColumns) {
        weekColumns.remove(weekColumns.size() - 1);
        weekColumns.remove(weekColumns.size() - 1);

        weekColumns.forEach(column -> {
            ObservableList<Node> children = column.getChildren();
            Label columnDate = (Label) children.get(0);
            Label morningSession = (Label) children.get(1);
            Label afternoonSession = (Label) children.get(2);
            Label hoursLate = (Label) children.get(3);
            Label earlyLeave = (Label) children.get(4);

            OfficerDataByDayDTO dataByDay = officerDetailController.getDataByDay(employeeId,
                    columnDate.getText().split("\\n")[1]);

            morningSession.setText(dataByDay.getMorningShift() ? "Có" : "Vắng");
            afternoonSession.setText(dataByDay.getAfternoonShift() ? "Có" : "Vắng");
            hoursLate.setText(dataByDay.getHourLate().toString()) ;
            earlyLeave.setText(dataByDay.getEarlyLeave().toString());
        });
    }
}
