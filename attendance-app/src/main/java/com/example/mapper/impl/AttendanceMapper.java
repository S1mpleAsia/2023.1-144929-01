package mapper.impl;

import mapper.RowMapper;
import model.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceMapper implements RowMapper<Attendance> {
    private static AttendanceMapper attendanceMapper = null;

    @Override
    public Attendance mapRow(ResultSet rs) throws SQLException{
        Attendance attendance = new Attendance();
        try {
            attendance.setId(rs.getInt("id"));
            attendance.setEmployeeId(rs.getString("employee_id"));
            attendance.setTimeIn(LocalDateTime.parse(rs.getString("time_in"), DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss")));
            attendance.setTimeOut(LocalDateTime.parse(rs.getString("time_out"), DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss")));
            attendance.setEmployeeName(rs.getString("name"));
            attendance.setDepartmentName(rs.getString("department_name"));

            return attendance;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static AttendanceMapper getInstance(){
        if(attendanceMapper == null) attendanceMapper = new AttendanceMapper();
        return attendanceMapper;
    }

}
