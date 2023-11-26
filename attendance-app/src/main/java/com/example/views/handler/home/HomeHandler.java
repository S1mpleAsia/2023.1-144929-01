package views.handler.home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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
    private TableView<?> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void handlePressRow(MouseEvent event) {
        if(event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            Object selectedItem = table.getSelectionModel().getSelectedItem();

            System.out.println(selectedItem);
        }
    }

}
