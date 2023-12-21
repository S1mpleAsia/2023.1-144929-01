package views.handler.home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import subsystem.database.impl.AttendanceRepository;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.home.impl.HomeController;
import usecase.home.IHomeController;
import dto.TableDataDTO;
import utils.Constraints;
import utils.store.ContextFactory;
import views.handler.BaseHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HomeHandler extends BaseHandler implements Initializable {

    @FXML
    public TableColumn <?, ?> date;

    @FXML
    public TableColumn <?, ?> timein;

    public TableColumn <?, ?> timeout;

    @FXML
    private AnchorPane content;

    @FXML
    private TableColumn<?, ?> deparment;

    @FXML
    private AnchorPane navBar;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;


    @FXML
    private TableView<TableDataDTO> table;

    @FXML
    private IHomeController homeController;

    private final ObservableList<TableDataDTO> tableData = FXCollections.observableArrayList();
    List<AnchorPane> navBarList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeController = new HomeController(AttendanceRepository.getInstance());
        tableData.clear();
        tableData.addAll(homeController.getTableData(1));
        id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        deparment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        timein.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        timeout.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
        date.setCellValueFactory(new PropertyValueFactory<>("Date"));;
        table.setItems(tableData);
        initNavbarList();
    }

    private void initNavbarList() {
        ObservableList<Node> children = navBar.getChildren();
        for (Node child : children) {
            if (child instanceof AnchorPane) navBarList.add((AnchorPane) child);
        }
        navBarList.get(0).getStyleClass().add("navbar-active");
    }
    @FXML
    void handleNavBarPress(MouseEvent event) {
        AnchorPane component = (AnchorPane) event.getSource();

        navBarList.forEach(item -> {
            Label label = (Label) item.getChildren().get(1);
            if(item == component) {
                label.getStyleClass().remove("navbar-inactive");
                label.getStyleClass().add("navbar-active");
            }
            else {
                label.getStyleClass().remove("navbar-active");
                label.getStyleClass().add("navbar-inactive");
            }
        });
        changeContentView(Constraints.LIST_EDITANCE_REQUEST_PATH, content);
    }

    public void handleRequest(AnchorPane anchorPane){
        changeContentView(Constraints.LIST_EDITANCE_REQUEST_PATH, anchorPane);
    }
    @FXML
    void handleBackScreen(MouseEvent event) throws IOException {
        navigate(Constraints.HOME_SCREEN_PATH, Constraints.HOME_STYLESHEET_PATH, event);
    }

}
