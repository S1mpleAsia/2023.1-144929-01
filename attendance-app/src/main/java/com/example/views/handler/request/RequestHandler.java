package views.handler.request;

import dto.OfficerDataByDayDTO;
import dto.RequestDTO;
import dto.TableDataDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Attendance;
import subsystem.hrsystem.IAttendanceRepository;
import subsystem.hrsystem.impl.AttendanceRepository;
import subsystem.hrsystem.impl.RequestRepository;
import subsystem.timekeepingmachine.impl.RecordRepository;
import usecase.detail.IDetailController;
import usecase.detail.impl.OfficerDetailController;
import usecase.request.impl.RequestController;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class RequestHandler extends BaseHandler implements Initializable {
    @FXML
    public TextField employeeName;
    @FXML
    public TextField checkin;
    @FXML
    public TextField checkout;

    @FXML
    public Button submit;

    @FXML
    public Button cancel;
    @FXML
    public TextArea reason;
    @FXML
    public DatePicker date;
    @FXML
    public ChoiceBox<String> requestType;
    private final String[] type= {"ADD", "DELETE", "EDIT"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        requestType.getItems().addAll(type);
        employeeName.setEditable(false);

        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");
        String observerDate = ((LocalDate) ContextFactory.getContext().getItem("date")).toString();
        Integer employeeId = (Integer) ContextFactory.getContext().getItem("userEmployeeId");
        IDetailController<OfficerDataByDayDTO> monthlyAttendanceController = new OfficerDetailController(RecordRepository.getInstance());
        OfficerDataByDayDTO officerDataByDay = monthlyAttendanceController.getDataByDay(employeeInfo.getEmployeeId(), observerDate);
        ContextFactory.getContext().putItem("employeeDataByDay", officerDataByDay);
        RequestController requestController = new RequestController(AttendanceRepository.getInstance(), RequestRepository.getInstance());
        OfficerDataByDayDTO officerDataByDayDTO = requestController.getOfficerDataByDay(employeeId, observerDate);
        ContextFactory.getContext().putItem("attendance_id", officerDataByDayDTO.getAttendance_id());
        System.out.println(officerDataByDayDTO);
        checkin.setText(officerDataByDayDTO.getTime_in());
        checkout.setText(officerDataByDayDTO.getTime_out());
        employeeName.setText(employeeInfo.getEmployeeName());
        date.setValue(LocalDate.parse(observerDate));
    }
    @FXML
    public void createNewRequest(){
        RequestDTO requestDTO = new RequestDTO();

        Integer employeeId = (Integer) ContextFactory.getContext().getItem("userEmployeeId");

        requestDTO.setEmployee_id(employeeId);
        requestDTO.setType_request(requestType.getValue());
        requestDTO.setReason(reason.getText());
        requestDTO.setTime_in(checkin.getText());
        requestDTO.setTime_out(checkout.getText());
        requestDTO.setCreate_day(LocalDate.now().toString());
        requestDTO.setAttendance_id((Integer)ContextFactory.getContext().getItem("attendance_id"));



        RequestController requestController = new RequestController(AttendanceRepository.getInstance(), RequestRepository.getInstance());
        Long id = requestController.createNewRequest(requestDTO);
        if (id != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Tạo yêu cầu thành công");
        }
    }

    @FXML
    public void backToHome(){
    }
}
