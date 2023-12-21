package usecase.request.impl;

import javafx.scene.layout.AnchorPane;
import model.Editance;
import subsystem.AbstractRepository;
import usecase.request.IConfirmController;
import utils.Constraints;
import utils.store.RequestContext;
import views.handler.home.HomeHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfirmController extends AbstractRepository<Editance> implements IConfirmController {
    private final HomeHandler homeHandler = new HomeHandler();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void Confirm(Integer id,Integer aId, String type, Integer employeeId, LocalDateTime timeIn, LocalDateTime timeOut){
        Integer action = (Integer) RequestContext.getContext().getItem("action");
        if(action == 1){
            if(type.equals("Thêm")){
                String sql = "INSERT INTO attendance (employee_id, time_in, time_out) VALUES (?, ?, ?)";
                Object[] params = {employeeId, timeIn.format(formatter), timeOut.format(formatter) };
                update(sql, params);
            } else if (type.equals("Sửa")) {
                String Sql = "UPDATE attendance SET time_in = ?, time_out = ? WHERE id = ?";
                Object[] params = { timeIn.format(formatter), timeOut.format(formatter), aId};
                update(Sql, params);
            }
            else {
                String sql = "DELETE FROM attendance WHERE id = ?";
                Object[] params = {aId};
                update(sql, params);
            }
            String sql = "UPDATE request SET status = ? WHERE id = ?";
            Object[] params = {"DONE", id};
            update(sql, params);
        }else{
            String sql = "UPDATE request SET status = ? WHERE id = ?";
            Object[] params = {"DENY", id};
            update(sql, params);
        }
    }

    public void reCall(){
        AnchorPane anchorPane = (AnchorPane) RequestContext.getContext().getItem("anchor");
        homeHandler.handleRequest(anchorPane);
    }

}
