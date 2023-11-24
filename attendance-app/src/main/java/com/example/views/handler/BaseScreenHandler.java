package views.handler;

import javafx.scene.Scene;
import javafx.stage.Stage;
import usecase.BaseController;

import java.io.IOException;

public class BaseScreenHandler extends FXMLScreenHandler{
    protected final Stage stage;
    private Scene scene;
    private BaseScreenHandler prev;
    private BaseController baseController;

    public BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }

    public BaseScreenHandler(String screenPath, Stage stage) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    public void show() {
        if(this.scene == null) {
            this.scene = new Scene(this.content);
        }

        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public BaseScreenHandler getPrev() {
        return prev;
    }

    public void setPrev(BaseScreenHandler prev) {
        this.prev = prev;
    }

    public BaseController getBaseController() {
        return baseController;
    }

    public void setBaseController(BaseController baseController) {
        this.baseController = baseController;
    }
}
