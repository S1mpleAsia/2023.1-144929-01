package dto;

public class AttendanceDTO {
    private Integer employee_id;
    private String time_in;
    private String time_out;
    private Integer id;

    public Integer GetEmployeeId() {
        return employee_id;
    }

    public void SetEmployeeId(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




}
