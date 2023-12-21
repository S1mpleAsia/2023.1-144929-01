package subsystem.database;

import model.Editance;
import subsystem.GenericRepository;
import java.util.List;

public interface IEditanceRepository extends GenericRepository<Editance> {
    List<Editance> allEditance();

}
