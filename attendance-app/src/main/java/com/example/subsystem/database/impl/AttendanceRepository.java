package subsystem.database.impl;

import mapper.impl.AttendanceMapper;
import model.Attendance;
import subsystem.AbstractRepository;
import subsystem.database.IAttendanceRepository;

import java.util.List;
public class AttendanceRepository extends AbstractRepository<Attendance> implements IAttendanceRepository {
    private static AttendanceRepository attendanceRepository = null;

    public static AttendanceRepository getInstance(){
        if (attendanceRepository == null) attendanceRepository = new AttendanceRepository();
        return attendanceRepository;
    }
    @Override
    public List<Attendance> allAttendance(){
        String sql = "SELECT attendance.id, attendance.time_in, attendance.time_out, employee.employee_id, employee.name, department.department_name " +
                "FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id " +
                "INNER JOIN department ON employee.department_id = department.id ORDER BY attendance.time_in";
        List<Attendance> attendanceList = query(sql, AttendanceMapper.getInstance());
        return attendanceList.isEmpty() ? null : attendanceList;
    }
}
