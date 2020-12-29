package test.graphic;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class GameStatus {

    private HBox hBox;

    private Label scorePlayer01;
    private int score01=0;

    private Label scorePlayer02;
    private int score02=0;

    private Label music;
    private Button musicPause;
    private Button musicPlay;

    public GameStatus() {

        intinalize();
    }

    /*
     * FUNCTION FOR CONSTRUCTOR
     * */

    private void intinalize() {

        hBox = new HBox(10);
        hBox.setStyle("-fx-background-color: #66d63a; -fx-min-width: 850");

        scorePlayer01 = new Label(String.valueOf(score01));
        scorePlayer01.setStyle("-fx-font-size: 30; -fx-text-alignment: CENTER;");

        Label space = new Label("        ");
        space.setStyle("-fx-font-size: 30");

        scorePlayer02 = new Label(String.valueOf(score02));
        scorePlayer02.setStyle("-fx-font-size: 30; -fx-text-alignment: CENTER;");

        music = new Label("♫ :");
        musicPause = new Button("Pause");
        musicPlay = new Button("Play");

        music.setStyle("-fx-font-size: 20; -fx-arc-width: 100");
        musicPause.setStyle("-fx-font-size: 15; -fx-arc-width: 100");
        musicPlay.setStyle("-fx-font-size: 15; -fx-arc-width: 100");

        hBox.getChildren().addAll(scorePlayer01, new Label(" - "), scorePlayer02, space, music, musicPause, musicPlay);
    }

    /*-------------------------------------------------*/

    public Pane getHBox() {
        return this.hBox;
    }
}
