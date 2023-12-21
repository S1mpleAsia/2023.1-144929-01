package dto;

import model.Record;

import java.util.List;

public class WorkerDataByDayDTO extends EmployeeDataByDayDTO {
    private Double shift1;
    private Double shift2;
    private Double shift3;
    public WorkerDataByDayDTO() {
    }

    public WorkerDataByDayDTO(List<Record> recordList) {
        super(recordList);
    }

    public Double getShift1() {
        return shift1;
    }

    public void setShift1(Double shift1) {
        this.shift1 = shift1;
    }

    public Double getShift2() {
        return shift2;
    }

    public void setShift2(Double shift2) {
        this.shift2 = shift2;
    }

    public Double getShift3() {
        return shift3;
    }

    public void setShift3(Double shift3) {
        this.shift3 = shift3;
    }

    public void calculateShift() {
    }
}
