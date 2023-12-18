package model;

import java.time.LocalDateTime;

public class Attendance {
    private Integer id;

    private String employeeId;

    private LocalDateTime timeIn;

    private LocalDateTime timeOut;

    private String employeeName;

    private String departmentName;

    public Attendance(){}
    public Attendance(Integer id, String employeeId, LocalDateTime timeIn, LocalDateTime timeOut, String departmentName, String employeeName){
        this.id = id;
        this.employeeId = employeeId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.departmentName= departmentName;
        this.employeeName = employeeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
