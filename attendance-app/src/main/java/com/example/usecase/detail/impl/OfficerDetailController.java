package usecase.detail.impl;

import dto.OfficerDataByDayDTO;
import dto.TransformTime;
import subsystem.timekeepingmachine.IRecordRepository;
import usecase.detail.AbstractDetailController;
import utils.Constraints;
import utils.Utils;

import java.time.LocalDate;

public class OfficerDetailController extends AbstractDetailController<OfficerDataByDayDTO> {
    public OfficerDetailController(IRecordRepository recordRepository) {
        super(recordRepository);
    }

    @Override
    public OfficerDataByDayDTO getDataByDay(String employeeId, LocalDate date) {
        String stringDate = date.toString();

        String startOfDay = stringDate + " " + Constraints.START_OF_DAY;
        String startShiftOne = stringDate + " " + Constraints.START_SHIFT_1;
        String endShiftOne = stringDate + " " + Constraints.END_SHIFT_1;

        String startShiftTwo = stringDate + " " + Constraints.START_SHIFT_2;
        String endShiftTwo = stringDate + " " + Constraints.END_SHIFT_2;

        String startShiftThree = stringDate + " " + Constraints.START_SHIFT_3;
        String endShiftThree = stringDate + " " + Constraints.END_SHIFT_3;

        String endOfDay = stringDate + " " + Constraints.END_OF_DAY;

        OfficerDataByDayDTO dataByDayDTO = new OfficerDataByDayDTO(getRecordListByEmployeeIdAndDate(employeeId, date));

        double hourLate = 0.0;
        double earlyLeave = 0.0;

        TransformTime morningTime = calculateShift(employeeId, startShiftOne, endShiftOne, startOfDay, startShiftTwo);
        TransformTime afternoonTime = calculateShift(employeeId, startShiftTwo, endShiftTwo, endShiftOne, startShiftThree);
        TransformTime overtime = calculateShift(employeeId, startShiftThree, endShiftThree, endShiftTwo, endOfDay);

        if(morningTime.getCheckIn() > 8.0) hourLate += morningTime.getCheckIn() - 8.0;
        if(morningTime.getCheckOut() < 12.0 && morningTime.getCheckOut() > 8.0) earlyLeave += 12.0 - morningTime.getCheckOut();

        if(afternoonTime.getCheckIn() > 13.5) hourLate += afternoonTime.getCheckIn() - 13.5;
        if(afternoonTime.getCheckOut() < 17.5 && afternoonTime.getCheckOut() > 13.5) earlyLeave += 17.5 - afternoonTime.getCheckOut();

        dataByDayDTO.setMorningTime(morningTime.getWorkTime());
        dataByDayDTO.setAfternoonTime(afternoonTime.getWorkTime());
        dataByDayDTO.setMorningShift(morningTime.getWorkTime() > 0 && morningTime.getWorkTime() <= 4);
        dataByDayDTO.setAfternoonShift(afternoonTime.getWorkTime() > 0 && afternoonTime.getWorkTime() <= 4);
        dataByDayDTO.setOvertime(overtime.getWorkTime());
        dataByDayDTO.setHourLate(Utils.roundValue(hourLate));
        dataByDayDTO.setEarlyLeave(Utils.roundValue(earlyLeave));

        return dataByDayDTO;
    }
}
