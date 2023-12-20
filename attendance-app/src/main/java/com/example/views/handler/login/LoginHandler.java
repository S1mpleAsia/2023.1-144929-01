package views.handler.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Account;
import model.Employee;
import subsystem.database.impl.AccountRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import usecase.login.ILoginController;
import usecase.login.impl.LoginController;
import usecase.officer_home.iml.OfficerHomeController;
import utils.Constraints;
import utils.Utils;
import utils.store.ContextFactory;
import views.handler.BaseHandler;
import views.handler.officer_home.OfficerHomeHandler;

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

        if(account == null) throw new RuntimeException("User not found");

        LOGGER.info("Login successfully");

        /* TODO: Check role */
        checkUserRole(account, actionEvent);
    }

    private String getUsername(TextField username) {
        return username.getText();
    }

    private String getPassword(TextField password) {
        return password.getText();
    }
    private void checkUserRole(Account account, ActionEvent actionEvent) throws IOException {
        String role = account.getRole();
        ContextFactory.getContext().putItem("userEmployeeId", account.getEmployeeId());
        if ("manager".equals(role.toLowerCase())) {
            navigate(Constraints.HOME_SCREEN_PATH, Constraints.HOME_STYLESHEET_PATH, actionEvent);

        } else {
            navigate(Constraints.OFFICER_HOME_SCREEN_PATH, Constraints.OFFICER_HOME_STYLESHEET_PATH, actionEvent);
        }
    }
}
