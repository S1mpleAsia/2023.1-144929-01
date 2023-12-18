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

    @Override
    public List<EditTableDTO> getTableData() {
        List<EditTableDTO> tableData = new ArrayList<>(Collections.emptyList());
        List<Editance> editanceList = editanceRepository.allEditance("PENDING");
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        editanceList.forEach(editance -> {
            EditTableDTO tableDataDTO = new EditTableDTO();
            tableDataDTO.setId(editance.getId());
            tableDataDTO.setEmployeeName(editance.getName());
            tableDataDTO.setType(Type(editance.getTypeRequest()));
            tableDataDTO.setRequestDay(editance.getTimeIn().format(formatDay));
            tableDataDTO.setEmployeeId(editance.getEmployeeId());
            tableDataDTO.setCreateDay(editance.getCreateDay().format(formatDay));
            tableData.add(tableDataDTO);
        });
        return tableData;
    }

}
