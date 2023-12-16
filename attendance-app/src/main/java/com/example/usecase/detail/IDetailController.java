package usecase.detail;

import dto.TransformTime;
import model.Record;

import java.time.LocalDate;
import java.util.List;

public interface IDetailController<T> {
    List<Record> getRecordListByEmployeeIdAndDate(String employeeId, LocalDate date);
    T getDataByDay(String employeeId, LocalDate date);
    TransformTime calculateShift(String employeeId, String startShift, String endShift, String standardStart, String standardEnd);
}
