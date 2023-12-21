package views.handler.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Account;
import subsystem.database.impl.AccountRepository;
import usecase.login.ILoginController;
import usecase.login.impl.LoginController;
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
        loginController = new LoginController(AccountRepository.getInstance());
    }

    public void login(ActionEvent actionEvent) throws IOException {
        Account account = loginController.findByUsernameAndPassword(getUsername(username), getPassword(password));

        if (account == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thông tin đăng nhập không chính xác");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
            return;
        }

        LOGGER.info("Login successfully");

        /* TODO: Check role */
        navigate(Constraints.HOME_SCREEN_PATH, Constraints.HOME_STYLESHEET_PATH, actionEvent);
    }

    private String getUsername(TextField username) {
        return username.getText();
    }

    private String getPassword(TextField password) {
        return password.getText();
    }
}
