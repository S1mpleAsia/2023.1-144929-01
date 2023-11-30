package subsystem.database.impl;

import mapper.impl.AccountMapper;
import model.Account;
import subsystem.AbstractRepository;
import subsystem.database.IUserRepository;

import java.util.List;

public class UserRepository extends AbstractRepository<Account> implements IUserRepository {
    private static UserRepository userRepository = null;

    @Override
    public Account findById(Integer id) {
        String sql = "SELECT * FROM [user] WHERE id = ?";

        List<Account> accounts = query(sql, AccountMapper.getInstance(), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM account WHERE username = ? AND PASSWORD = ?";

        List<Account> accountList = query(sql, AccountMapper.getInstance(), username, password);

        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT * FROM [user]";

        List<Account> accounts = query(sql, AccountMapper.getInstance());
        return accounts.isEmpty() ? null : accounts;
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }

        return userRepository;
    }
}
