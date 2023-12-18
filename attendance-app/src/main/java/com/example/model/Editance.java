package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Editance {
    private Integer id;

    private Integer attendanceId;

    private String employeeId;

    private LocalDateTime createDay;

    private String typeRequest;

    private String reason;

    private LocalDateTime timeIn;

    private LocalDateTime timeOut;

    private String status;

    private String name;

    public Editance(){}

    public Editance(Integer id, Integer attendanceId,String employeeId,
             LocalDateTime createDay, String typeRequest, String reason,
             LocalDateTime timeIn, LocalDateTime timeOut, String status, String name){
        this.id = id;
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.createDay = createDay;
        this.typeRequest = typeRequest;
        this.reason = reason;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public LocalDateTime getCreateDay() {
        return createDay;
    }

    public void setCreateDay(LocalDateTime createDay) {
        this.createDay = createDay;
    }

    public String getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
