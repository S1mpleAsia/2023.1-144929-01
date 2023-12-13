package views.handler.home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.home.controller.HomeController;
import usecase.home.controller.IHomeController;
import usecase.home.dto.TableDataDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeHandler implements Initializable {
    @FXML
    private TableColumn<?, ?> age;

    @FXML
    private TableColumn<?, ?> deparment;

    @FXML
    private TextField departmentLabel;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;


    @FXML
    private TableView<TableDataDTO> table;

    private IHomeController homeController;

    private final ObservableList<TableDataDTO> tableData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeController = new HomeController(EmployeeRepository.getInstance(), DepartmentRepository.getInstance());
        tableData.clear();
        tableData.addAll(homeController.getTableData(1));


        id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        name.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        deparment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));

        table.setItems(tableData);
    }


    @FXML
    void handleViewOverview(MouseEvent event) {
        if(event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            Object selectedItem = table.getSelectionModel().getSelectedItem();

            System.out.println(selectedItem);
        }
    }

}
