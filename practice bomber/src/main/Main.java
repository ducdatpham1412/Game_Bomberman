package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.graphic.GraphicControl;
import main.graphic.pvp.BoardGame;
import main.graphic.pvp.InGame;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        GraphicControl control = new GraphicControl();

        stage.setScene(control.scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
