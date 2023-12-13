package views.handler;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public abstract class BaseHandler {
    public void navigate(String viewPath, String styleSheetPath, Event event) throws IOException {
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

    public void displayView(String viewPath, String styleSheetPath, Event event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewPath)));

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        if (styleSheetPath != null) {
            scene.getStylesheets().add(String.valueOf(getClass().getResource(styleSheetPath)));
        }

        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.showAndWait();
    }

    public void changeContentView(String viewPath, AnchorPane contentRoot) {
        contentRoot.getChildren().clear();

        Parent rootChild = null;

        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        contentRoot.getChildren().add(rootChild);
    }
}
