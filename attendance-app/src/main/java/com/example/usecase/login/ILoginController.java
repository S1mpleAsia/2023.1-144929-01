package usecase.login;

import model.User;

public interface ILoginController {
    User findByUsernameAndPassword(String username, String password);
}
