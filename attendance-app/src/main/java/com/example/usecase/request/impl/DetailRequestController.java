package usecase.request.impl;

import dto.DetailRequestDTO;
import model.Editance;
import subsystem.database.IEditanceRepository;
import usecase.request.IDetailRequest;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DetailRequestController implements IDetailRequest {
    private final IEditanceRepository editanceRepository;

    public DetailRequestController(IEditanceRepository editanceRepository){
        this.editanceRepository = editanceRepository;
    }

    @Override
    public DetailRequestDTO getTableData(Integer id){
        DetailRequestDTO tableData = new DetailRequestDTO();
        List<Editance> Request = editanceRepository.allEditance("PENDING");
        Editance detailRequest = null;
        for (Editance editance : Request) {
            if (editance.getId() == id) {
                detailRequest = editance;
                break;
            }
        }
        if(detailRequest != null){
            DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("HH:mm");
            tableData.setReason(detailRequest.getReason());
            tableData.setCreateDay(detailRequest.getCreateDay().format(formatDay));
            tableData.setId(detailRequest.getId());
            tableData.setRequestDay(detailRequest.getTimeIn().format(formatDay));
            tableData.setTimeIn(detailRequest.getTimeIn().format(formatHour));
            tableData.setTimeOut(detailRequest.getTimeOut().format(formatHour));
            return tableData;
        }
        return null;
    }
}
