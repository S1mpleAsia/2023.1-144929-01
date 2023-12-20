package usecase.request.impl;

import model.Editance;
import subsystem.AbstractRepository;
import usecase.request.IConfirmController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfirmController extends AbstractRepository<Editance> implements IConfirmController {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void Confirm(Integer id, String type, Integer employeeId, LocalDateTime timeIn, LocalDateTime timeOut){
        if(type.equals("Thêm")){
            String sql = "INSERT INTO attendance (employee_id, time_in, time_out) VALUES (?, ?, ?)";
            Object[] params = {employeeId, timeIn.format(formatter), timeOut.format(formatter) };
            update(sql, params);
        } else if (type.equals("Sửa")) {
            String Sql = "UPDATE attendance SET time_in = ?, time_out = ? WHERE id = ?";
            Object[] params = { timeIn, timeOut, id};
            update(Sql, params);
        }
        else {
            String sql = "DELETE FROM attendance WHERE id = ?";
            Object[] params = {id};
            update(sql, params);
        }
    }

    public void Quit(){

    }

}
