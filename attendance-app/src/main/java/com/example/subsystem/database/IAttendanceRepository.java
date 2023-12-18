package subsystem.database;

import model.Attendance;
import subsystem.GenericRepository;

import java.util.List;
public interface IAttendanceRepository extends GenericRepository<Attendance> {
    List<Attendance> allAttendance ();
}
