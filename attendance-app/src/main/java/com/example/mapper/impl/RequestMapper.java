package mapper.impl;

import mapper.RowMapper;
import model.Attendance;
import model.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<Request> {
    private static RequestMapper requestMapper = null;
    @Override
    public Request mapRow(ResultSet rs) throws SQLException {
        Request request = new Request();

        try {
            request.setEmployee_id(rs.getInt("employee_id"));
            request.setAttendance_id(rs.getInt("attendance_id"));
            request.setCreate_day(rs.getString("create_day"));
            request.setType_request(rs.getString("type_request"));
            request.setReason(rs.getString("reason"));

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
