package usecase.request;

import dto.DetailRequestDTO;

public interface IDetailRequest {
    DetailRequestDTO getTableData(Integer id);

}
