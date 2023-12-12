package mapper.impl;

import mapper.RowMapper;
import model.Record;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordMapper implements RowMapper<Record> {
    private static RecordMapper recordMapper = null;

    @Override
    public Record mapRow(ResultSet rs) throws SQLException {
        Record record = new Record();

        try {
            record.setId(rs.getInt("id"));
            record.setEmployeeId(rs.getString("employee_id"));
            record.setCheckTime(LocalDateTime.parse(rs.getString("check_time"), DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss")));

            return record;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static RecordMapper getInstance() {
        if(recordMapper == null) recordMapper = new RecordMapper();

        return recordMapper;
    }


}
