package mapper.impl;

import mapper.RowMapper;
import model.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AttendanceMapper implements RowMapper<Attendance> {
    private static AttendanceMapper attendanceMapper = null;
    @Override
    public Attendance mapRow(ResultSet rs) throws SQLException {
        Attendance attendance = new Attendance();

        try {
            attendance.setId(rs.getInt("id"));
            attendance.setEmployee_id(rs.getInt("employee_id"));
            attendance.setTime_in(rs.getString("time_in"));
            attendance.setTime_out(rs.getString("time_out"));

            return attendance;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static AttendanceMapper getInstance() {
        if(attendanceMapper == null) attendanceMapper = new AttendanceMapper();

        return attendanceMapper;
    }
}
