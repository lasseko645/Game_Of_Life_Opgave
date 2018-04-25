package sample.com.ushulabubko.front_end;
import javafx.scene.control.*;
import sample.com.ushulabubko.back_end.*;
import javafx.fxml.*;


public class Controller {

    @FXML
    public TextArea textPrintArea;

    public Button updateButton;

    Game goi = new Game();

    public TextArea getTextPrintArea() {
        return textPrintArea;
    }

    public void setTekstPrint(String n){
        textPrintArea.setText(n);
    }

    public void handleButtonClick() {

        goi.setupUpdate();

    }
}
