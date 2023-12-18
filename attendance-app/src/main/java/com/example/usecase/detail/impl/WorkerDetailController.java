package usecase.detail.impl;

import dto.WorkerDataByDayDTO;
import subsystem.timekeepingmachine.IRecordRepository;
import usecase.detail.BaseDetailController;
import utils.Constraints;

import java.time.LocalDate;

public class WorkerDetailController extends BaseDetailController<WorkerDataByDayDTO> {
    public WorkerDetailController(IRecordRepository recordRepository) {
        super(recordRepository);
    }

    @Override
    public WorkerDataByDayDTO getData(String employeeId, LocalDate date) {
        String stringDate = date.toString();

        String startOfDay = stringDate + " " + Constraints.START_OF_DAY;
        String startShiftOne = stringDate + " " + Constraints.START_SHIFT_1;
        String endShiftOne = stringDate + " " + Constraints.END_SHIFT_1;

        String startShiftTwo = stringDate + " " + Constraints.START_SHIFT_2;
        String endShiftTwo = stringDate + " " + Constraints.END_SHIFT_2;

        String startShiftThree = stringDate + " " + Constraints.START_SHIFT_3;
        String endShiftThree = stringDate + " " + Constraints.END_SHIFT_3;
        String endOfDay = stringDate + " " + Constraints.END_OF_DAY;


        WorkerDataByDayDTO dataByDayDTO = new WorkerDataByDayDTO(getRecordListByEmployeeIdAndDate(employeeId, date));
        dataByDayDTO.setShift1(
                calculateShift(employeeId, startShiftOne,
                        endShiftOne, startOfDay,
                        startShiftTwo).getWorkTime());

        dataByDayDTO.setShift2(
                calculateShift(employeeId, startShiftTwo,
                        endShiftTwo, endShiftOne,
                        startShiftThree).getWorkTime());

        dataByDayDTO.setShift3(
                calculateShift(employeeId, startShiftThree,
                        endShiftThree, endShiftTwo,
                        endOfDay).getWorkTime());

        return dataByDayDTO;
    }
}
