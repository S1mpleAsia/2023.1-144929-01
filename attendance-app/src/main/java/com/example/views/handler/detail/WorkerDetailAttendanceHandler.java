package views.handler.detail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import subsystem.timekeepingmachine.impl.RecordRepository;
import usecase.detail.IDetailController;
import usecase.detail.impl.WorkerDetailController;
import dto.WorkerDataByDayDTO;
import dto.TableDataDTO;
import utils.Constraints;
import utils.EmployeeType;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class WorkerDetailAttendanceHandler extends BaseHandler implements Initializable {

    @FXML
    private TextField attendanceDate;

    @FXML
    private TextField employeeIdLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField shiftOneLabel;

    @FXML
    private TextField shiftThreeLabel;

    @FXML
    private TextField shiftTwoLabel;

    @FXML
    private TextField typeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");
        String observerDate = ((LocalDate) ContextFactory.getContext().getItem("date")).toString();

        IDetailController<WorkerDataByDayDTO> monthlyAttendanceController = new WorkerDetailController(RecordRepository.getInstance());
        WorkerDataByDayDTO workerDataByDay = monthlyAttendanceController.getDataByDay(employeeInfo.getEmployeeId(), observerDate);
        ContextFactory.getContext().putItem("employeeDataByDay", workerDataByDay);

        nameLabel.setText(employeeInfo.getEmployeeName());
        employeeIdLabel.setText(employeeInfo.getEmployeeId());
        attendanceDate.setText(observerDate.toString());
        typeLabel.setText(EmployeeType.WORKER.name());

        shiftOneLabel.setText(workerDataByDay.getShift1().toString());
        shiftTwoLabel.setText(workerDataByDay.getShift2().toString());
        shiftThreeLabel.setText(workerDataByDay.getShift3().toString());
    }

    @FXML
    void handleExport(ActionEvent event) {

    }

    @FXML
    void handleGetParticularInfo(ActionEvent event) throws IOException {
        displayView(Constraints.WORKER_PARTICULAR_SCREEN_PATH, Constraints.WORKER_PARTICULAR_STYLESHEET_PATH, event);
    }


}
