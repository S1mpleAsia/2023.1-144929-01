package usecase.request;

import dto.DetailRequestDTO;

public interface IDetailRequestController {
    DetailRequestDTO getTableData(Integer id);

}
