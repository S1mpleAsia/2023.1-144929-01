package usecase.home.impl;

import model.Attendance;
import model.Department;
import model.Employee;
import subsystem.database.IAttendanceRepository;
import subsystem.hrsystem.IDepartmentRepository;
import subsystem.hrsystem.IEmployeeRepository;
import dto.TableDataDTO;
import usecase.home.IHomeController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeController implements IHomeController {
    private final IAttendanceRepository attendanceRepository;

    public HomeController(IAttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<TableDataDTO> getTableData(Integer departmentId) {

        List<TableDataDTO> tableData = new ArrayList<>(Collections.emptyList());

        List<Attendance> attendanceList = attendanceRepository.allAttendance();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        attendanceList.forEach(attendance -> {
            TableDataDTO tableDataDTO  = new TableDataDTO();
            tableDataDTO.setDepartmentName(attendance.getDepartmentName());
            tableDataDTO.setEmployeeId(attendance.getEmployeeId());
            tableDataDTO.setEmployeeName(attendance.getEmployeeName());
            tableDataDTO.setTimeIn(attendance.getTimeIn().format(formatter));
            tableDataDTO.setTimeOut(attendance.getTimeOut().format(formatter));
            tableDataDTO.setDate(attendance.getTimeIn().format(formatDay));
            tableData.add(tableDataDTO);
        });

        return tableData;
    }
}
