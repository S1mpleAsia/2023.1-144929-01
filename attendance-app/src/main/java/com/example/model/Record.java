package model;

import java.time.LocalDateTime;

public class Record {
    private Integer id;
    private String employeeId;
    private LocalDateTime checkTime;

    public Record() {
    }

    public Record(Integer id, String employeeId, LocalDateTime checkTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.checkTime = checkTime;
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

    public LocalDateTime getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(LocalDateTime checkTime) {
        this.checkTime = checkTime;
    }
}
