package dto;

import utils.EmployeeType;

import java.util.Date;
import java.util.List;

public class WorkerDataByMonthDTO {
    private String workerName;
    private String workerType = EmployeeType.WORKER.name();
    private String employeeId;
    private List<WorkerDataByDayDTO> dataByDay;
    private Date date;
}
