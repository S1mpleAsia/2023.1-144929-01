package views.handler.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import subsystem.database.impl.UserRepository;
import usecase.login.ILoginController;
import usecase.login.LoginController;
import utils.Constraints;
import utils.Utils;
import views.handler.BaseHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginHandler extends BaseHandler implements Initializable {
    public static Logger LOGGER = Utils.getLogger(LoginHandler.class.getName());
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    private ILoginController loginController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginController = new LoginController(UserRepository.getInstance());
    }

    public void login(ActionEvent actionEvent) throws IOException {
        User user = loginController.findByUsernameAndPassword(getUsername(username), getPassword(password));

        if(user == null) throw new RuntimeException("User not found");

        LOGGER.info("Login successfully");

        /* TODO: Check role */
        navigate(Constraints.HOME_SCREEN_PATH, null, actionEvent);
    }

    private String getUsername(TextField username) {
        return username.getText();
    }

    private String getPassword(TextField password) {
        return password.getText();
    }
}
