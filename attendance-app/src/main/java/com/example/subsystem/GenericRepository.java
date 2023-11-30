package subsystem;

import mapper.RowMapper;

import java.util.List;

/**
 *
 * @param <T> Object model
 */
public interface GenericRepository<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
    Long insert(String sql, Object... params);
    void update(String sql, Object... params);
}
