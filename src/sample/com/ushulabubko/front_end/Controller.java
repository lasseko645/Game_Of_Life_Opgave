package sample.com.ushulabubko.front_end;
import javafx.scene.control.*;
import sample.com.ushulabubko.back_end.*;


public class Controller {

    public Button updateButton;

    public void handleButtonClick() {

        Game goi = new Game();
        goi.setupUpdate();
    }
}
