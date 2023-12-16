package views.handler.detail;

import dto.OfficerDataByDayDTO;
import dto.TableDataDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import subsystem.timekeepingmachine.impl.RecordRepository;
import usecase.detail.IDetailController;
import usecase.detail.impl.OfficerDetailController;
import utils.Constraints;
import utils.EmployeeType;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OfficerDetailAttendanceHandler extends BaseHandler implements Initializable {

    @FXML
    private TextField afternoonLabel;

    @FXML
    private TextField attendanceDate;

    @FXML
    private TextField earlyLabel;

    @FXML
    private TextField employeeIdLabel;

    @FXML
    private TextField lateLabel;

    @FXML
    private TextField morningLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField overtimeLabel;

    @FXML
    private TextField summary;

    @FXML
    private TextField typeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");
        LocalDate observerDate = (LocalDate) ContextFactory.getContext().getItem("date");

        IDetailController<OfficerDataByDayDTO> monthlyAttendanceController = new OfficerDetailController(RecordRepository.getInstance());
        OfficerDataByDayDTO officerDataByDay = monthlyAttendanceController.getDataByDay(employeeInfo.getEmployeeId(), observerDate);
        ContextFactory.getContext().putItem("employeeDataByDay", officerDataByDay);

        nameLabel.setText(employeeInfo.getEmployeeName());
        employeeIdLabel.setText(employeeInfo.getEmployeeId());
        attendanceDate.setText(observerDate.toString());
        typeLabel.setText(EmployeeType.OFFICER.name());

        morningLabel.setText(officerDataByDay.getMorningShift() ? "Có mặt" : "Vắng mặt");
        afternoonLabel.setText(officerDataByDay.getAfternoonShift() ? "Có mặt" : "Vắng mặt");
        earlyLabel.setText(officerDataByDay.getEarlyLeave().toString());
        lateLabel.setText(officerDataByDay.getHourLate().toString());
        overtimeLabel.setText(officerDataByDay.getOvertime().toString());
        summary.setText(officerDataByDay.getSummary().toString());
    }

    @FXML
    void handleExport(ActionEvent event) {

    }

    @FXML
    void handleGetParticularInfo(ActionEvent event) throws IOException {
        displayView(Constraints.WORKER_PARTICULAR_SCREEN_PATH, Constraints.WORKER_PARTICULAR_STYLESHEET_PATH, event);
    }

}
