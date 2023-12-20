package mapper.impl;

import mapper.RowMapper;
import model.Editance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditanceMapper implements RowMapper<Editance> {
    private static EditanceMapper editanceMapper = null;

    @Override
    public Editance mapRow(ResultSet rs) throws SQLException {
        Editance editance = new Editance();
        try {
            editance.setId(rs.getInt("id"));
            editance.setEmployeeId(rs.getString("employeeId"));
            editance.setAttendanceId(rs.getInt("attendance_id"));
            editance.setCreateDay(LocalDateTime.parse(rs.getString("create_day"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            editance.setReason(rs.getString("reason"));
            editance.setTypeRequest(rs.getString("type_request"));
            editance.setTimeIn(LocalDateTime.parse(rs.getString("time_in"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            editance.setTimeOut(LocalDateTime.parse(rs.getString("time_out"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            editance.setStatus(rs.getString("status"));
            editance.setName(rs.getString("name"));
            editance.seteId(rs.getInt("employee_id"));
            return editance;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static EditanceMapper getInstance(){
        if(editanceMapper == null) editanceMapper = new EditanceMapper();

        return editanceMapper;
    }
}
