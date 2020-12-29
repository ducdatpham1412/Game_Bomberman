package main.graphic.pvp;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import main.graphic.pvp.GameStatus;
import main.graphic.pvp.InGame;


public class BoardGame {


    /*
    * BoardGame is a BorderPane include 2 elements are InGame and GameStatus
    * */
    private BorderPane mainPane = new BorderPane();

    private InGame inGame;
    private GameStatus gameStatus;
    private MediaPlayer mediaPlayer;


    /*
    * Constructor
    * */
    public BoardGame() {

        initialize();
    }


    /*
    * Functions support for Constructor
    * */
    private void initialize() {

        mainPane = new BorderPane();

        gameStatus = new GameStatus();
        inGame = new InGame();

        mainPane.setCenter(inGame.getMainPane());
        mainPane.setTop(gameStatus.getMainPane());
    }

    /*
    * HAM GETTER, SETTER
    * */
    public BorderPane getMainPane() {
        return this.mainPane;
    }

    public InGame getInGame() {
        return inGame;
    }
}
