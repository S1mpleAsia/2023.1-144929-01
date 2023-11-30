package views.handler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public abstract class BaseHandler {
    public void navigate(String viewPath, String styleSheetPath, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewPath)));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        if (styleSheetPath != null) {
            scene.getStylesheets().add(String.valueOf(getClass().getResource(styleSheetPath)));
        }

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
