package views.handler.request;

import dto.EditTableDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import subsystem.database.impl.EditanceRepository;
import usecase.request.impl.EditanceController;
import utils.Constraints;
import utils.store.ContextFactory;
import utils.store.RequestContext;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestHandler extends BaseHandler implements Initializable {

    public TableColumn <?, ?> status;

    public AnchorPane anchorpane;
    @FXML
    private TableView <EditTableDTO> table;

    @FXML
    private TableColumn <?, ?> id;

    @FXML
    private TableColumn <?, ?> name;

    @FXML
    private TableColumn <?, ?> request_day;

    @FXML
    private TableColumn <?, ?> create_day;

    @FXML
    private TableColumn <?, ?> type;

    private EditanceController editanceController;

    private final ObservableList<EditTableDTO> tableData = FXCollections.observableArrayList();

    public void initialize (URL url, ResourceBundle resourceBundle){
        RequestContext.getContext().putItem("anchor", anchorpane);
        editanceController = new EditanceController(EditanceRepository.getInstance());
        tableData.clear();
        tableData.addAll(editanceController.getTableData());
        id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        request_day.setCellValueFactory(new PropertyValueFactory<>("requestDay"));
        create_day.setCellValueFactory(new PropertyValueFactory<>("createDay"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(tableData);
    }

    public void handleViewOverView(MouseEvent mouseEvent) throws IOException
    {
        if(mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2){
            EditTableDTO selectedItem = table.getSelectionModel().getSelectedItem();
            RequestContext.getContext().putItem("name", selectedItem.getEmployeeName());

            //For update
            RequestContext.getContext().putItem("id", selectedItem.getId());
            RequestContext.getContext().putItem("aId", selectedItem.getAttendanceId());
            RequestContext.getContext().putItem("type", selectedItem.getType());
            if(selectedItem.getStatus().equals("Chờ xử lý")){
                if(selectedItem.getType().equals("Thêm")) {
                    displayView(Constraints.REQUEST_DETAIL_PATH, Constraints.REQUEST_DETAIL_STYLESHEET_PATH, mouseEvent);
                } else if (selectedItem.getType().equals("Sửa")) {
                    displayView(Constraints.REQUEST_EDIT_PATH, Constraints.REQUEST_DETAIL_STYLESHEET_PATH, mouseEvent);
                } else {
                    displayView(Constraints.REQUEST_DELETE_PATH, Constraints.REQUEST_DETAIL_STYLESHEET_PATH, mouseEvent);
                }
            }
        }
    }
}
