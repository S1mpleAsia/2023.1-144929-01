package usecase.detail;

import dto.OfficerDataByDayDTO;
import model.Record;
import dto.WorkerDataByDayDTO;

import java.time.LocalDate;
import java.util.List;

public interface IMonthlyAttendanceController<T> {
    List<Record> getRecordListByEmployeeIdAndDate(String employeeId, LocalDate date);
    T getDataByDay(String employeeId, LocalDate date);
}
