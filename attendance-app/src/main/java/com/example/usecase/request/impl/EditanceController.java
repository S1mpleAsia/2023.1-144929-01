package usecase.request.impl;

import dto.EditTableDTO;
import model.Editance;
import subsystem.database.IEditanceRepository;
import usecase.request.IEditanceController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EditanceController implements IEditanceController {
    private final IEditanceRepository editanceRepository;

    public EditanceController (IEditanceRepository editanceRepository){
        this.editanceRepository = editanceRepository;
    }

    private String Type (String type){
        if(type.equals("ADD")) return "Thêm";
        if(type.equals("EDIT")) return "Sửa";
        return "Xóa";
    }

    private String Status (String status) {
        if(status.equals("PENDING")) return "Chờ xử lý";
        if(status.equals("DONE")) return "Chấp nhận";
        return "Từ chối";
    }

    @Override
    public List<EditTableDTO> getTableData() {
        List<EditTableDTO> tableData = new ArrayList<>(Collections.emptyList());
        List<Editance> editanceList = editanceRepository.allEditance();
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        editanceList.forEach(editance -> {
            EditTableDTO tableDataDTO = new EditTableDTO();
            tableDataDTO.setId(editance.getId());
            tableDataDTO.setAttendanceId(editance.getAttendanceId());
            tableDataDTO.setEmployeeName(editance.getName());
            tableDataDTO.setType(Type(editance.getTypeRequest()));
            tableDataDTO.setRequestDay(editance.getTimeOut().format(formatDay));
            tableDataDTO.setEmployeeId(editance.getEmployeeId());
            tableDataDTO.setCreateDay(editance.getCreateDay().format(formatDay));
            tableDataDTO.setStatus(Status(editance.getStatus()));
            tableData.add(tableDataDTO);
        });
        return tableData;
    }

}
