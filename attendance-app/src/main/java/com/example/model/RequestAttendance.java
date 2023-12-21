package com.example.model;
public class RequestAttendance {
    private Integer _attendanceId;
    private Integer _employeeId;
    private String _createDay;
    private String _requestType;
    private String _reason;

    
    public Integer GetEmployeeId() {
        return _employeeId;
    }
    
    public void SetEmployeeId(Integer employeeId) {
        this._employeeId = employeeId;
    }
    public Integer GetAttendanceId() {
        return _attendanceId;
    }

    public void SetAttendanceId(Integer attendanceId) {
        this._attendanceId = attendanceId;
    }

    
    public String GetRequestType() {
        return _requestType;
    }
    
    public void SetRequestType(String requestType) {
        this._requestType = requestType;
    }
    
    public String GetReason() {
        return _reason;
    }
    
    public void SetReason(String reason) {
        this._reason = reason;
    }
    public String GetCreateDay() {
        return _createDay;
    }

    public void SetCreateDay(String createDay) {
        this._createDay = createDay;
    }



}
