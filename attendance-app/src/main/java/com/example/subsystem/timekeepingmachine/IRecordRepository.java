package subsystem.timekeepingmachine;

import model.Record;
import subsystem.GenericRepository;

import java.time.LocalDate;
import java.util.List;

public interface IRecordRepository extends GenericRepository<Record> {
    List<Record> getRecordListByEmployeeIdAndDate(String employeeId, LocalDate date);
    Record getFirstRecordOfTime(String employeeId, String stringDate);
    Record getLastRecordOfTime(String employeeId, String stringDate);

}
