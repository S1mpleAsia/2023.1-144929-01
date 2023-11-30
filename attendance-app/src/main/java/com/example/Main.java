import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import utils.Constraints;
import utils.Utils;

import java.util.Objects;
import java.util.logging.Logger;

public class Main extends Application {
    private static final Logger LOGGER = Utils.getLogger(Main.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try {
            AnchorPane root = FXMLLoader
                    .load(Objects.requireNonNull(getClass().getResource(Constraints.LOGIN_SCREEN_PATH)));

            Scene scene = new Scene(root);
            scene.getStylesheets().add(String.valueOf(getClass().getResource(Constraints.LOGIN_STYLESHEET_PATH)));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            LOGGER.severe("Error from Main");
            e.printStackTrace();
        }
    }
}