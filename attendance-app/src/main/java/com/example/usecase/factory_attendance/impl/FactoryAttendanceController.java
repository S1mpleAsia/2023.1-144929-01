package usecase.factory_attendance.impl;

import dto.FactoryAttendanceDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Department;
import model.Employee;
import subsystem.hrsystem.IDepartmentRepository;
import subsystem.hrsystem.IEmployeeRepository;
import subsystem.hrsystem.impl.DepartmentRepository;
import subsystem.hrsystem.impl.EmployeeRepository;
import subsystem.timekeepingmachine.IRecordRepository;
import usecase.factory_attendance.BaseFactoryController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

import enums.Shift;
import utils.Constraints;

public class FactoryAttendanceController extends BaseFactoryController<ObservableList<FactoryAttendanceDTO>> {
    public FactoryAttendanceController(IRecordRepository recordRepository) {
        super(recordRepository);
    }

    @Override
    public ObservableList<FactoryAttendanceDTO> getFactoryAttendanceTableData(Integer departmentId, LocalDate date) {
        Department department = DepartmentRepository.getInstance().findByDepartmentId(departmentId);
        if(department == null) throw new RuntimeException("No department found");

        List<LocalDate> weekDates = getWeekDateTimes(date);

        List<Employee> employeeList = EmployeeRepository.getInstance().findAllByDepartmentId(departmentId);
        ObservableList<FactoryAttendanceDTO> tableData = FXCollections.observableArrayList();

        employeeList.forEach(employee -> {
            for(Shift shift: Shift.values()){
                Map<String, Double> shiftTime = new HashMap<>();
                shiftTime.put("mondayTime" ,0.0);
                shiftTime.put("tuesdayTime", 0.0);
                shiftTime.put("wednesdayTime", 0.0);
                shiftTime.put("thursdayTime", 0.0);
                shiftTime.put("fridayTime", 0.0);
                ObservableList<String> listShiftTime = FXCollections.observableArrayList();
                listShiftTime.addAll(shiftTime.keySet());
                for (int dayIndex = 0; dayIndex < 5; dayIndex++){
                    Map<String, String> shiftData = getShiftDataByDate(weekDates.get(dayIndex));
                    System.out.println(weekDates.get(dayIndex));
                    shiftTime.put(listShiftTime.get(dayIndex), calculateShift(employee.getEmployeeId(), shiftData.get(shift + "_s"),
                            shiftData.get(shift + "_e"), shiftData.get(shift + "_p"),
                            shiftData.get(shift + "_n")).getWorkTime());
                }
                System.out.println(shiftTime);
                FactoryAttendanceDTO factoryAttendanceDTO  = new FactoryAttendanceDTO(employee.getName(), shift,
                        shiftTime.get("mondayTime"), shiftTime.get("tuesdayTime"), shiftTime.get("wednesdayTime"),
                        shiftTime.get("thursdayTime"), shiftTime.get("fridayTime"));

                tableData.add(factoryAttendanceDTO);
            }

        });

        return tableData;
    }

    public List<LocalDate> getWeekDateTimes(LocalDate currentDate) {
        int currentIndex = currentDate.getDayOfWeek().getValue(); // Mon-1 Sun-7

        List<LocalDate> weekDates = new ArrayList<>();

        for(int i = 0;i < 7; i++) {
            LocalDate tempDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());
            weekDates.add(tempDate.minusDays(currentIndex - i - 1));
        }

        return weekDates;
    }

    public Map<String, String> getShiftDataByDate(LocalDate date) {
        String stringDate = date.toString();

        String startOfDay = stringDate + " " + Constraints.START_OF_DAY;
        String startShiftOne = stringDate + " " + Constraints.START_SHIFT_1;
        String endShiftOne = stringDate + " " + Constraints.END_SHIFT_1;

        String startShiftTwo = stringDate + " " + Constraints.START_SHIFT_2;
        String endShiftTwo = stringDate + " " + Constraints.END_SHIFT_2;

        String startShiftThree = stringDate + " " + Constraints.START_SHIFT_3;
        String endShiftThree = stringDate + " " + Constraints.END_SHIFT_3;
        String endOfDay = stringDate + " " + Constraints.END_OF_DAY;

        Map<String, String> shiftData = new HashMap<>();

        shiftData.put(Shift.Shift1.toString() + "_p", startOfDay);
        shiftData.put(Shift.Shift1.toString() + "_s", startShiftOne);
        shiftData.put(Shift.Shift1.toString() + "_e", endShiftOne);
        shiftData.put(Shift.Shift1.toString() + "_n", startShiftTwo);

        shiftData.put(Shift.Shift2.toString() + "_p", endShiftOne);
        shiftData.put(Shift.Shift2.toString() + "_s", startShiftTwo);
        shiftData.put(Shift.Shift2.toString() + "_e", endShiftTwo);
        shiftData.put(Shift.Shift2.toString() + "_n", startShiftThree);

        shiftData.put(Shift.Shift3.toString() + "_p", endShiftTwo);
        shiftData.put(Shift.Shift3.toString() + "_s", startShiftThree);
        shiftData.put(Shift.Shift3.toString() + "_e", endShiftThree);
        shiftData.put(Shift.Shift3.toString() + "_n", endOfDay);

        return shiftData;
    }
}
