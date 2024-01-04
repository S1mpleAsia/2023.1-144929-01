package usecase.factory_attendance;

import dto.FactoryAttendanceDTO;
import dto.TransformTime;

import java.util.List;

public interface IFactoryAttendanceController<T> {
    List<FactoryAttendanceDTO> getFactoryAttendanceTableData(Integer departmentId);

    T getDataByDay(Integer departmentId, String date);
    TransformTime calculateShift(String employeeId, String startShift, String endShift, String standardStart, String standardEnd);
}
