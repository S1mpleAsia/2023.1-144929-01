package usecase.request;

import java.time.LocalDateTime;

public interface IConfirmController {

    void Confirm (Integer id,Integer aId, String type, Integer employeeId, LocalDateTime timeIn, LocalDateTime timeOut);

}
