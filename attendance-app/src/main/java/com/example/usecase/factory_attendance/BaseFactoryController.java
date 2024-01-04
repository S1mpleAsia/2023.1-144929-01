package usecase.factory_attendance;

import dto.FactoryAttendanceDTO;
import dto.TransformTime;
import model.Record;
import subsystem.timekeepingmachine.IRecordRepository;
import utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public abstract class BaseFactoryController<T> implements IFactoryAttendanceController<T>{
    protected final IRecordRepository recordRepository;

    public BaseFactoryController(IRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<FactoryAttendanceDTO> getFactoryAttendanceTableData(Integer departmentId) {
        return null;
    }

    public LocalDate validateDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public TransformTime calculateShift(String employeeId, String startShift, String endShift, String standardStart, String standardEnd) {
        Record startShiftBefore = recordRepository.getLastRecordOfTime(employeeId, startShift);
        Record startShiftAfter = recordRepository.getFirstRecordOfTime(employeeId, startShift);
        Record endShiftBefore = recordRepository.getLastRecordOfTime(employeeId, endShift);
        Record endShiftAfter = recordRepository.getFirstRecordOfTime(employeeId, endShift);

        double startHour = 0.0, endHour = 0.0;

        if (startShiftBefore != null && Utils.getTimeFromLocalDateTime(startShiftBefore.getCheckTime()) >=
                Utils.getTimeFromLocalDateTime(Utils.dateTimeConvert(standardStart))) {
            double time = Utils.getTimeFromLocalDateTime(startShiftBefore.getCheckTime());
            if (time <= 8.0) startHour = 8.0;
            else if (time > 12.0 && time <= 13.5) startHour = 13.5;
            else if (time > 17.5 && time <= 18.0) startHour = 18.0;
        } else {
            if (startShiftAfter == null) return new TransformTime(0.0, 0.0, 0.0);

            startHour = Utils.getTimeFromLocalDateTime(startShiftAfter.getCheckTime());
        }

        if (endShiftAfter != null
                && Utils.getTimeFromLocalDateTime(endShiftAfter.getCheckTime()) <=
                Utils.getTimeFromLocalDateTime(Utils.dateTimeConvert(standardEnd))) {
            double time = Utils.getTimeFromLocalDateTime(endShiftAfter.getCheckTime());

            if (time >= 12 && time < 13.5) endHour = 12.0;
            if (time >= 17.5 && time < 18) endHour = 17.5;
            if (time >= 22) endHour = 22.0;
        } else {
            if (endShiftBefore == null) return new TransformTime(0.0, 0.0, 0.0);

            double startTime = Utils.getTimeFromLocalDateTime(Objects.requireNonNullElse(startShiftBefore, startShiftAfter).getCheckTime());

            endHour = Utils.getTimeFromLocalDateTime(endShiftBefore.getCheckTime());
            if (endHour == startTime) return new TransformTime(0.0, 0.0, 0.0);
        }

        return new TransformTime(Utils.roundValue(endHour - startHour), startHour, endHour);
    }

    public abstract T getFactoryAttendanceTableData(Integer departmentId, LocalDate date);

    @Override
    public T getDataByDay(Integer departmentId, String date) {
        LocalDate localDate = validateDate(date);
        return getFactoryAttendanceTableData(departmentId, localDate);
    }
}
