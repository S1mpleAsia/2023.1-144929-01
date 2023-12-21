package subsystem.database;

import model.Account;
import subsystem.GenericRepository;

import java.util.List;

public interface IAccountRepository extends GenericRepository<Account> {
    Account findById(Integer id);
    Account findByUsernameAndPassword(String username, String password);
    List<Account> findAll();
}
