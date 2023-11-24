package views.handler.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import subsystem.database.IUserRepository;
import subsystem.database.impl.UserRepository;
import utils.Utils;
import views.handler.BaseScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginHandler implements Initializable {
    public static Logger LOGGER = Utils.getLogger(LoginHandler.class.getName());
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    private IUserRepository userRepository;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userRepository = new UserRepository();
    }

    public void login(ActionEvent actionEvent) {
        User user = userRepository.findByUsernameAndPassword(getUsername(username), getPassword(password));

        if(user == null) throw new RuntimeException("User not found");

        LOGGER.info("Login successfully");
    }

    private String getUsername(TextField username) {
        return username.getText();
    }

    private String getPassword(TextField password) {
        return password.getText();
    }
}
