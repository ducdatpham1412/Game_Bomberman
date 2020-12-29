package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.controller.MapController;
import test.graphic.BoardGame;


public class Main extends Application  {

    @Override
    public void start(Stage stage) throws Exception {

        BoardGame board = new BoardGame();

        Scene sc = board.getScene();

        stage.setTitle("Bomberman");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
