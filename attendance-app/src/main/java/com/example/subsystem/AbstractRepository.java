package subsystem;

import mapper.RowMapper;
import utils.Constraints;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @param <T> Object Model
 * @author duongvt
 * @since 24/11/2023
 */
public class AbstractRepository<T> implements GenericRepository<T> {
    private Connection getConnection() {
        try {
            Class.forName(Constraints.DB_DRIVER_NAME);
            String url = "jdbc:mysql://" +
                    Constraints.DB_HOST_NAME + ":" + Constraints.DB_PORT +
                    "/" + Constraints.DB_INSTANCE;

            return DriverManager.getConnection(url, Constraints.DB_USER, Constraints.DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
        List<T> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            /* Get connection to DB */
            connection = getConnection();
            assert connection != null;

            /* Set parameter */
            statement = connection.prepareStatement(sql);
            setParameter(statement, params);

            /* Execute query */
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if(resultSet != null) resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... params) {
        try {
            for(int i = 0;i < params.length; i++) {
                Object parameter = params[i];
                int index = i + 1;
                if(parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                }

                else if(parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                }

                else if(parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                }

                else if(parameter instanceof Date) {
                    statement.setDate(index, (Date) parameter);
                }

                else if(parameter == null) {
                    statement.setNull(index,Types.NVARCHAR);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long insert(String sql, Object... params) {
        return null;
    }

    @Override
    public void update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            /* Get connection to DB */
            connection = getConnection();
            assert connection != null;

            /* Set parameters */
            statement = connection.prepareStatement(sql);
            setParameter(statement, params);

            /* Execute update query */
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
