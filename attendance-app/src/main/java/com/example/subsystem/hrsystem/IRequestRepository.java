package subsystem.hrsystem;

import dto.RequestDTO;
import model.Department;
import model.Request;
import subsystem.GenericRepository;

public interface IRequestRepository extends GenericRepository<Request> {
    Long createNewRequest (RequestDTO request);
}
