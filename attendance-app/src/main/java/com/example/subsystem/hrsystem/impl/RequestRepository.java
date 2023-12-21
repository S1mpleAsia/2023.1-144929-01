package subsystem.hrsystem.impl;

import dto.RequestDTO;
import model.Request;
import subsystem.AbstractRepository;
import subsystem.hrsystem.IRequestRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class RequestRepository extends AbstractRepository<RequestAttendance> implements IRequestRepository {
    private static RequestRepository requestRepository = null;
    public static RequestRepository getInstance() {
        if (requestRepository == null) {
            requestRepository = new RequestRepository();
        }

        return requestRepository;
    }

    @Override
    public Long createNewRequest(RequestAttendanceDTO request) {
        String sql = "INSERT INTO `request`(`attendance_id`, `employee_id`, `create_day`, `type_request`, `reason`, `time_in`, `time_out`) VALUES (?,?,?,?,?,?,?)";
        return insert(sql,
                request.GetAttendanceId(),
                request.GetEmployeeId(),
                LocalDate.now().toString(),
                request.GetRequestType(),
                request.GetReason(),
                request.GetTimeIn(),
                request.GetTimeOut());
    }
}
