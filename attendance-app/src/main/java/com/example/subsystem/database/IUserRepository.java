package subsystem.database;

import model.User;
import subsystem.GenericRepository;

import java.util.List;

public interface IUserRepository extends GenericRepository<User> {
    User findById(Integer id);
    User findByUsernameAndPassword(String username, String password);
    List<User> findAll();
}
