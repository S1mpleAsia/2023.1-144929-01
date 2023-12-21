package subsystem.hrsystem.impl;

import dto.RequestDTO;
import model.Request;
import subsystem.AbstractRepository;
import subsystem.hrsystem.IRequestRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class RequestRepository extends AbstractRepository<Request> implements IRequestRepository {
    private static RequestRepository requestRepository = null;
    public static RequestRepository getInstance() {
        if (requestRepository == null) {
            requestRepository = new RequestRepository();
        }

        return requestRepository;
    }

    @Override
    public Long createNewRequest(RequestDTO request) {
        String sql = "INSERT INTO `request`(`attendance_id`, `employee_id`, `create_day`, `type_request`, `reason`, `time_in`, `time_out`) VALUES (?,?,?,?,?,?,?)";
        return insert(sql,
                request.getAttendance_id(),
                request.getEmployee_id(),
                LocalDate.now().toString(),
                request.getType_request(),
                request.getReason(),
                request.getTime_in(),
                request.getTime_out());
    }
}
