package usecase.request;

import dto.OfficerDataByDayDTO;
import dto.RequestDTO;

public interface IRequestController {
    OfficerDataByDayDTO getOfficerDataByDay(Integer employee_id, String day);
    Long createNewRequest(RequestDTO requestDTO);

}
