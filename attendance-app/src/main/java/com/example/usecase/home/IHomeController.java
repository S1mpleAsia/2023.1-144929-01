package usecase.home;

import dto.TableDataDTO;

import java.util.List;

public interface IHomeController {
    List<TableDataDTO> getTableData(Integer departmentId);
}
