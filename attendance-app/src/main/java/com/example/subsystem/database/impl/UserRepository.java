package subsystem.database.impl;

import mapper.impl.UserMapper;
import model.User;
import subsystem.AbstractRepository;
import subsystem.database.IUserRepository;

import java.util.List;

public class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Override
    public User findById(Integer id) {
        String sql = "SELECT * FROM [user] WHERE id = ?";

        List<User> users = query(sql, UserMapper.getInstance(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND PASSWORD = ?";

        List<User> userList = query(sql, UserMapper.getInstance(), username, password);

        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM [user]";

        List<User> users = query(sql, UserMapper.getInstance());
        return users.isEmpty() ? null : users;
    }
}
