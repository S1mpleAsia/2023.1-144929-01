package views.handler.request;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import usecase.request.impl.ConfirmController;
import utils.store.RequestContext;
import views.handler.BaseHandler;
import javafx.stage.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ConfirmHandler extends BaseHandler implements Initializable {

        @FXML
        private Text textLabel;
        private ConfirmController confirmController;

        Integer id = (Integer) RequestContext.getContext().getItem("id");
        String type = (String) RequestContext.getContext().getItem("type");
        Integer action = (Integer) RequestContext.getContext().getItem("action");
        Integer aId = (Integer) RequestContext.getContext().getItem("aId");
        Integer eId = (Integer) RequestContext.getContext().getItem("eId");
        LocalDateTime timeIn = (LocalDateTime) RequestContext.getContext().getItem("timeIn");
        LocalDateTime timeOut = (LocalDateTime) RequestContext.getContext().getItem("timeOut");

        public void initialize (URL url, ResourceBundle resourceBundle){

                this.confirmController = new ConfirmController();

                System.out.println(id);
                System.out.println(aId);
                System.out.println(eId);
                System.out.println(timeIn);
                System.out.println(timeOut);

                if(type.equals("Thêm")){
                        if(action == 0) {
                                textLabel.setText("Từ chối xử lý yêu cầu số " + (id+100000));
                        }
                        else textLabel.setText("Xác nhận xử lý yêu cầu số " + (id+100000));
                }
                else if(type.equals("Sửa")){
                        if(action == 0) {
                                textLabel.setText("Từ chối xử lý yêu cầu số " + (id+200000));
                        }
                        else textLabel.setText("Xác nhận xử lý yêu cầu số " + (id+200000));
                }
                else {
                        if(action == 0) {
                                textLabel.setText("Từ chối xử lý yêu cầu số " + (id+300000));
                        }
                        else textLabel.setText("Xác nhận xử lý yêu cầu số " + (id+300000));
                }
        }

        @FXML
        void handleConfirm(MouseEvent event) {
                confirmController.Confirm(aId ,type, eId, timeIn, timeOut);
                handleQuit(event);
        }

        @FXML
        void handleQuit(MouseEvent event) {
                Node source = (Node) event.getSource();
                Scene scene = source.getScene();
                Stage stage = (Stage) scene.getWindow();
                stage.close();
        }



}
