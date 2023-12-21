package com.example.dto;
public class RequestAttendanceDTO {
    private Integer _attendanceId;
    private Integer _employeeId;
    private String _createDay;
    private String _requestType;
    private String _reason;
    private String _timeIn;
    private String _timeOut;

    public String GetTimeIn() {
        return _timeIn;
    }

    public void SetTimeIn(String timeIn) {
        _timeIn = timeIn;
    }

    public String GetTimeOut() {
        return _timeOut;
    }

    public void SetTimeOut(String timeOut) {
        _timeOut = timeOut;
    }

    public Integer GetAttendanceId() {
        return _attendanceId;
    }

    public void SetAttendanceId(Integer attendanceId) {
        _attendanceId = attendanceId;
    }

    public Integer GetEmployeeId() {
        return _employeeId;
    }

    public void SetEmployeeId(Integer employeeId) {
        _employeeId = employeeId;
    }

    public String GetCreateDay() {
        return _createDay;
    }

    public void SetCreateDay(String create_day) {
        _createDay = create_day;
    }

    public String GetRequestType() {
        return _requestType;
    }

    public void SetRequestType(String type_request) {
        this._requestType = type_request;
    }

    public String GetReason() {
        return _reason;
    }

    public void SetReason(String reason) {
        this._reason = reason;
    }
}
