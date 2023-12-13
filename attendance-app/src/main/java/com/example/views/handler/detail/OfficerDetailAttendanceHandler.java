package views.handler.detail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import views.handler.BaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class OfficerDetailAttendanceHandler extends BaseHandler implements Initializable {

    @FXML
    private TextField afternoonLabel;

    @FXML
    private TextField attendanceDate;

    @FXML
    private TextField employeeIdLabel;

    @FXML
    private TextField morningLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField shiftThreeLabel;

    @FXML
    private TextField shiftThreeLabel2;

    @FXML
    private TextField shiftTwoLabel1;

    @FXML
    private TextField shiftTwoLabel11;

    @FXML
    private TextField typeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void handleExport(ActionEvent event) {

    }

    @FXML
    void handleGetParticularInfo(ActionEvent event) {

    }

}
