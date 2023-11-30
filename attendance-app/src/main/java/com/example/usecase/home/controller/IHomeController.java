package usecase.home.controller;

import usecase.home.dto.TableDataDTO;

import java.util.List;

public interface IHomeController {
    List<TableDataDTO> getTableData(Integer departmentId);
}
