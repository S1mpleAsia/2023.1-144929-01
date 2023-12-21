package subsystem.hrsystem;

import model.Attendance;
import model.Record;
import subsystem.GenericRepository;

public interface IAttendanceRepository extends GenericRepository<Attendance> {
    Attendance getOfficerDataByIdAndDay(Integer id, String day);

}
