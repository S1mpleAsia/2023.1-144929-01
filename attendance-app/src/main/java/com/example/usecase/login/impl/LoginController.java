package usecase.login.impl;

import model.Account;
import subsystem.database.IAccountRepository;
import usecase.login.ILoginController;

public class LoginController implements ILoginController {
    private final IAccountRepository userRepository;

    public LoginController(IAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
