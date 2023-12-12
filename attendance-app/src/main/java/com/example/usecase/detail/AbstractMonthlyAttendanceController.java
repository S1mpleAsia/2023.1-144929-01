package usecase.detail;

import model.Record;
import subsystem.timekeepingmachine.IRecordRepository;

import java.time.LocalDate;
import java.util.List;

public class AbstractMonthlyAttendanceController {
    protected final IRecordRepository recordRepository;

    public AbstractMonthlyAttendanceController(IRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getRecordListByEmployeeIdAndDate(String employeeId, LocalDate date) {
        return recordRepository.getRecordListByEmployeeIdAndDate("BK_20200125" ,date);
    }
}
