package dto;

import model.Record;

import java.util.List;

public class OfficerDataByDayDTO extends EmployeeDataByDayDTO {
    private Boolean morningShift;
    private Boolean afternoonShift;
    private Double morningTime;
    private Double afternoonTime;
    private Double hourLate;
    private Double earlyLeave;
    private Double overtime;

    public OfficerDataByDayDTO() {
    }

    public OfficerDataByDayDTO(List<Record> recordList) {
        super(recordList);
    }

    public Boolean getMorningShift() {
        return morningShift;
    }

    public void setMorningShift(Boolean morningShift) {
        this.morningShift = morningShift;
    }

    public Boolean getAfternoonShift() {
        return afternoonShift;
    }

    public void setAfternoonShift(Boolean afternoonShift) {
        this.afternoonShift = afternoonShift;
    }

    public Double getHourLate() {
        return hourLate;
    }

    public void setHourLate(Double hourLate) {
        this.hourLate = hourLate;
    }

    public Double getEarlyLeave() {
        return earlyLeave;
    }

    public void setEarlyLeave(Double earlyLeave) {
        this.earlyLeave = earlyLeave;
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public Double getMorningTime() {
        return morningTime;
    }

    public void setMorningTime(Double morningTime) {
        this.morningTime = morningTime;
    }

    public Double getAfternoonTime() {
        return afternoonTime;
    }

    public void setAfternoonTime(Double afternoonTime) {
        this.afternoonTime = afternoonTime;
    }

    public Double getSummary() {
        return morningTime + afternoonTime + overtime;
    }
}
