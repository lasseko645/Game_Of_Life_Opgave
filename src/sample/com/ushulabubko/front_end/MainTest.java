package sample.com.ushulabubko.front_end;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.Application;
import sample.com.ushulabubko.back_end.Game;
import sample.com.ushulabubko.back_end.Unit;

import java.io.IOException;

// ¤002 this part of testing was done following tutorials from the following links: https://www.youtube.com/watch?v=q5A-qW2eGKs

public class MainTest extends Application{



    private Stage primaryStage;
    private BorderPane mainApp;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Game gol = Game.initialize();

        Unit[][] worldMap = gol.getWorldSize();

        gol.setupUpdate();

    }







    public static void main(String[] args) {
        launch(args);

/*       // this was from an early test ¤001
        Game gol = Game.initialize();

        Unit[][] worldMap = gol.getWorldSize();

        //gol.debugWorldMethod();

        gol.setupUpdate();
        gol.setupUpdate();
        gol.setupUpdate();
        gol.setupUpdate();
*/


    }

    //methods



}
