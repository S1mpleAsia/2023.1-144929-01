package usecase.detail.impl;

import dto.OfficerDataByDayDTO;
import model.Record;
import subsystem.timekeepingmachine.IRecordRepository;
import usecase.detail.AbstractMonthlyAttendanceController;
import usecase.detail.IMonthlyAttendanceController;
import utils.Constraints;
import utils.Utils;

import java.time.LocalDate;

public class OfficerMonthlyAttendanceController extends AbstractMonthlyAttendanceController implements IMonthlyAttendanceController<OfficerDataByDayDTO> {
    public OfficerMonthlyAttendanceController(IRecordRepository recordRepository) {
        super(recordRepository);
    }

    @Override
    public OfficerDataByDayDTO getDataByDay(String employeeId, LocalDate date) {
        String stringDate = date.toString();
        String startShiftOne = stringDate + " " + Constraints.START_SHIFT_1;
        String endShiftOne = stringDate + " " + Constraints.END_SHIFT_1;

        String startShiftTwo = stringDate + " " + Constraints.START_SHIFT_2;
        String endShiftTwo = stringDate + " " + Constraints.END_SHIFT_2;

        String startShiftThree = stringDate + " " + Constraints.START_SHIFT_3;
        String endShiftThree = stringDate + " " + Constraints.END_SHIFT_3;

        OfficerDataByDayDTO dataByDayDTO = new OfficerDataByDayDTO(getRecordListByEmployeeIdAndDate(employeeId, date));

        double lateTime = 0.0;
        double morningTime = calculateShift(startShiftOne, endShiftOne);

        if(morningTime == 0.0) {
            dataByDayDTO.setMorningShift(false);
        }
        else if (morningTime <= 4.0 && morningTime > 0) {
            dataByDayDTO.setMorningShift(true);
            lateTime += 4.0 - morningTime;
        }


        return null;
    }

    private Double calculateShift(String startShift, String endShift) {
        Record startShiftBefore = recordRepository.getLastRecordOfTime("BK_20200125", startShift);
        Record startShiftAfter = recordRepository.getFirstRecordOfTime("BK_20200125", startShift);
        Record endShiftBefore = recordRepository.getLastRecordOfTime("BK_20200125", endShift);
        Record endShiftAfter = recordRepository.getFirstRecordOfTime("BK_20200125", endShift);

        double startHour = 0.0, endHour = 0.0;

        if (startShiftBefore != null) {
            double time = Utils.getTimeFromLocalDateTime(startShiftBefore.getCheckTime());
            if (time <= 8.0) startHour = 8.0;
            else if (time > 12.0 && time <= 13.5) startHour = 13.5;
            else if (time > 17.5 && time <= 18.0) startHour = 18.0;
        } else {
            if (startShiftAfter == null) return 0.0;

            startHour = Utils.getTimeFromLocalDateTime(startShiftAfter.getCheckTime());
        }

        if (endShiftAfter != null) {
            double time = Utils.getTimeFromLocalDateTime(endShiftAfter.getCheckTime());

            if (time >= 12 && time < 13.5) endHour = 12.0;
            if (time >= 17.5 && time < 18) endHour = 17.5;
            if (time >= 22) endHour = 22.0;
        } else {
            if (endShiftBefore == null) return 0.0;

            assert startShiftBefore != null;
            double startTime = Utils.getTimeFromLocalDateTime(startShiftBefore.getCheckTime());

            endHour = Utils.getTimeFromLocalDateTime(endShiftBefore.getCheckTime());
            if (endHour == startTime) return 0.0;
        }

        return Utils.roundValue(endHour - startHour);
    }
}
