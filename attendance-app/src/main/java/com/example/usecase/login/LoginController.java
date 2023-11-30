package usecase.login;

import model.Account;
import subsystem.database.IUserRepository;

public class LoginController implements ILoginController {
    private final IUserRepository userRepository;

    public LoginController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
