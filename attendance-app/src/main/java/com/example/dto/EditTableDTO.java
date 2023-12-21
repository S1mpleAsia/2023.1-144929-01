package dto;

// Display data for table
public class EditTableDTO {

    private Integer id;

    private Integer attendanceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String employeeId;

    private String employeeName;

    private String requestDay;

    private String createDay;

    private String type;

    private String status;

    public EditTableDTO(){

    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public EditTableDTO(String status ,Integer id, Integer attendanceId, String employeeId, String employeeName, String requestDay, String createDay, String type){
        this.createDay = createDay;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.requestDay = requestDay;
        this.type = type;
        this.id = id;
        this.attendanceId = attendanceId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRequestDay() {
        return requestDay;
    }

    public void setRequestDay(String requestDay) {
        this.requestDay = requestDay;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
