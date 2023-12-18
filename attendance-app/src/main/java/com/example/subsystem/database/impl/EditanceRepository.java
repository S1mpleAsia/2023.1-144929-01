package subsystem.database.impl;

import mapper.impl.EditanceMapper;
import model.Editance;
import subsystem.AbstractRepository;
import subsystem.database.IEditanceRepository;

import java.util.List;

public class EditanceRepository extends AbstractRepository<Editance> implements IEditanceRepository {
    private static EditanceRepository editanceRepository = null;

    public static EditanceRepository getInstance(){
        if(editanceRepository == null) editanceRepository = new EditanceRepository();
        return editanceRepository;
    }

    @Override
    public List<Editance> allEditance(String status){
        String sql = "SELECT request.*, employee.name, employee.employee_id as employeeId " +
                "FROM request INNER JOIN employee ON request.employee_id= employee.id " +
                "WHERE request.status = ?" ;
        List<Editance> editanceList = query(sql, EditanceMapper.getInstance(), status);
        return editanceList.isEmpty() ? null : editanceList;
    }

}
