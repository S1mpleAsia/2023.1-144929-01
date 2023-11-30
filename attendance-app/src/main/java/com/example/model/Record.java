package model;

import java.util.Date;

public class Record {
    private Integer id;
    private Integer employeeId;
    private Date checkTime;

    public Record() {
    }

    public Record(Integer id, Integer employeeId, Date checkTime) {
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
