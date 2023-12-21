package mapper.impl;

import mapper.RowMapper;
import model.Attendance;
import model.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<RequestAttendance> {
    private static RequestMapper requestMapper = null;
    @Override
    public RequestAttendance mapRow(ResultSet rs) throws SQLException {
        RequestAttendance request = new RequestAttendance();

        try {
            request.SetEmployeeId(rs.getInt("employee_id"));
            request.SetAttendanceId(rs.getInt("attendance_id"));
            request.SetCreateDay(rs.getString("create_day"));
            request.SetRequestType(rs.getString("type_request"));
            request.SetReason(rs.getString("reason"));

            return request;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static RequestMapper getInstance() {
        if(requestMapper == null) requestMapper = new RequestMapper();

        return requestMapper;
    }
}
