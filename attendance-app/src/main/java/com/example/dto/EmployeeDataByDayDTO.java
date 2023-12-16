package dto;

import model.Record;

import java.util.List;

public class EmployeeDataByDayDTO {
    private List<Record> recordList;

    public EmployeeDataByDayDTO() {
    }

    public EmployeeDataByDayDTO(List<Record> recordList) {
        this.recordList = recordList;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
