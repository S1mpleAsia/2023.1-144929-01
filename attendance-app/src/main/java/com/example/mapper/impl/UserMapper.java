package mapper.impl;

import mapper.RowMapper;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private static UserMapper userMapper = null;

    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user = new User();

        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserRole(rs.getString("user_role"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();;
        }

        return null;
    }

    public static UserMapper getInstance() {
        if(userMapper == null) userMapper = new UserMapper();

        return userMapper;
    }
}
