package dto;

import model.Record;

import java.util.List;

public class OfficerDataByDayDTO {
    private Boolean morningShift;
    private Boolean afternoonShift;
    private Double lateCheckIn;
    private Double earlyCheckout;
    private Double overtime;
    private List<Record> recordList;

    public OfficerDataByDayDTO() {
    }

    public OfficerDataByDayDTO(List<Record> recordList) {
        this.recordList = recordList;
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

    public Double getLateCheckIn() {
        return lateCheckIn;
    }

    public void setLateCheckIn(Double lateCheckIn) {
        this.lateCheckIn = lateCheckIn;
    }

    public Double getEarlyCheckout() {
        return earlyCheckout;
    }

    public void setEarlyCheckout(Double earlyCheckout) {
        this.earlyCheckout = earlyCheckout;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }
}
