package views.handler.detail;

import dto.EmployeeDataByDayDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dto.ParticularInfoDTO;
import dto.WorkerDataByDayDTO;
import dto.TableDataDTO;
import javafx.stage.Stage;
import utils.EmployeeType;
import utils.Utils;
import utils.store.ContextFactory;
import views.handler.BaseHandler;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ParticularInfoHandler extends BaseHandler implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private TableView<ParticularInfoDTO> tableView;

    @FXML
    private TableColumn<?, ?> checkTime;

    @FXML
    private TableColumn<?, ?> date;
    private final ObservableList<ParticularInfoDTO> tableData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeDataByDayDTO workerDataByDay = (EmployeeDataByDayDTO) ContextFactory.getContext().getItem("employeeDataByDay");
        TableDataDTO employeeInfo = (TableDataDTO) ContextFactory.getContext().getItem("employeeInfo");
        LocalDate observerDate = (LocalDate) ContextFactory.getContext().getItem("date");

        List<ParticularInfoDTO> particularInfoDTOList = new ArrayList<>();
        workerDataByDay.getRecordList().forEach(record -> {
            ParticularInfoDTO particularInfoDTO = new ParticularInfoDTO(observerDate.toString(), Utils.getStringTime(record.getCheckTime()));
            particularInfoDTOList.add(particularInfoDTO);
        });

        tableData.clear();
        tableData.addAll(particularInfoDTOList);

        nameLabel.setText(EmployeeType.WORKER.name() + ": " + employeeInfo.getEmployeeName());
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        checkTime.setCellValueFactory(new PropertyValueFactory<>("checkTime"));

        tableView.setItems(tableData);
    }

    @FXML
    void handleConfirm(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
