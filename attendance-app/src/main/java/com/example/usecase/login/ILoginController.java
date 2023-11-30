package usecase.login;

import model.Account;

public interface ILoginController {
    Account findByUsernameAndPassword(String username, String password);
}
