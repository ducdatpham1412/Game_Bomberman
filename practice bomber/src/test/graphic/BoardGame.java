package test.graphic;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class BoardGame {

    private BorderPane mainPane;
    private Scene scene;

    private InGame inGame;
    private GameStatus gameStatus;


    public BoardGame() {

        intinalize();
        asemble();
    }


    /*
    * FUNCTION FOR CONSTRUCTOR
    * */

    private void intinalize() {

        mainPane = new BorderPane();
        scene = new Scene(mainPane);

        inGame = new InGame();
        gameStatus = new GameStatus();
    }

    private void asemble() {

        mainPane.setCenter(inGame.getPaneGame());
        mainPane.setTop(gameStatus.getHBox());
    }

    /*-------------------------------------------------*/

    public Scene getScene() {
        return scene;
    }
}
