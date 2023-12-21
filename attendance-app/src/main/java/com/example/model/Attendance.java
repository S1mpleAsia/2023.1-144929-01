package model;

public class Attendance {
    private Integer employee_id;
    private String time_in;
    private String time_out;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attendance() {

    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public Attendance(Integer employeeId, String timeIn, String timeOut) {
        employee_id = employeeId;
        time_in = timeIn;
        time_out = timeOut;
    }
}
