package views.handler.request;

import dto.DetailRequestDTO;
import dto.EditTableDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import subsystem.database.impl.EditanceRepository;
import usecase.request.impl.DetailRequestController;
import utils.Constraints;
import utils.store.RequestContext;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailDeleteHandler extends BaseHandler implements Initializable {

    @FXML
    private Button confirm;

    @FXML
    private TableColumn<?, ?> createDay;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<?, ?> reason;

    @FXML
    private Button refuse;

    @FXML
    private TableColumn<?, ?> requestDay;

    @FXML
    private Label requestLabel;

    @FXML
    private TableView<DetailRequestDTO> tableView;

    private DetailRequestController detailController;

    private final ObservableList<DetailRequestDTO> tableData = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        detailController = new DetailRequestController(EditanceRepository.getInstance());
        Integer id = (Integer) RequestContext.getContext().getItem("id");
        String name = (String) RequestContext.getContext().getItem("name");
        tableData.add(detailController.getTableData(id));
        createDay.setCellValueFactory(new PropertyValueFactory<>("createDay"));
        requestDay.setCellValueFactory(new PropertyValueFactory<>("requestDay"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        requestLabel.setText( "Chi tiết yêu cầu chỉnh sửa số " + (id+300000));
        nameLabel.setText("Nhân viên " + name);
        tableView.setItems(tableData);
    }

    @FXML
    void handleConfirm(ActionEvent event) throws IOException {
        RequestContext.getContext().putItem("action", 1);
        displayView(Constraints.CONFIRM_PATH, Constraints.REQUEST_DETAIL_STYLESHEET_PATH, event);
    }

    @FXML
    void handleRefuse(ActionEvent event) throws IOException {
        RequestContext.getContext().putItem("action", 0);
        displayView(Constraints.CONFIRM_PATH, Constraints.REQUEST_DETAIL_STYLESHEET_PATH, event);
    }



}


