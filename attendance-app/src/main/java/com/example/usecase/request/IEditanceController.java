package usecase.request;

import dto.EditTableDTO;

import java.util.List;

public interface IEditanceController {
    List<EditTableDTO> getTableData();
}
