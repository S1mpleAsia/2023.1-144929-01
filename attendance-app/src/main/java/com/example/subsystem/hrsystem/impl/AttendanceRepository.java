package subsystem.hrsystem.impl;

import mapper.impl.AttendanceMapper;
import model.Attendance;
import model.Record;
import subsystem.AbstractRepository;
import subsystem.database.impl.AccountRepository;
import subsystem.hrsystem.IAttendanceRepository;

import java.util.List;

public class AttendanceRepository extends AbstractRepository<Attendance> implements IAttendanceRepository {
    private static AttendanceRepository attendanceRepository = null;
    @Override
    public Attendance getOfficerDataByIdAndDay(Integer id, String day) {
        String sql = "SELECT * FROM `attendance` WHERE employee_id=? and time_in like ?";
        String formattedDay = day + "%";
        List<Attendance> attendanceList = query(sql, AttendanceMapper.getInstance(),id, formattedDay);
        if (attendanceList == null || attendanceList.isEmpty()) {
            return null;
        }
        return attendanceList.get(0);
    }
    public static AttendanceRepository getInstance() {
        if (attendanceRepository == null) {
            attendanceRepository = new AttendanceRepository();
        }

        return attendanceRepository;
    }

}
