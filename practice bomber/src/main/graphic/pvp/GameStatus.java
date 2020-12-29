package main.graphic.pvp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.File;


public class GameStatus {

    private HBox mainPane;

    public Label TopScoreVal1, TopScoreVal2;
    public int scoreJ1, scoreJ2;
    public Label time;
    public int timeValue;

    public final Media media = new Media(new File("res/music/music.mp3").toURI().toString());
    public MediaPlayer player;

    private Button musicPause, musicPlay;

    public GameStatus() {

        initialize();
        action();
    }

    private void initialize() {

        mainPane = new HBox(9);


        Label TopTime = new Label("Time: ");
        time = new Label(String.valueOf(timeValue));
        Label TopTimeVal = new Label("        ");

        Label TopScore = new Label("Score: ");
        TopScoreVal1 = new Label(String.valueOf(scoreJ1));
        Label TopScoreM = new Label(" - ");
        TopScoreVal2 = new Label(String.valueOf(scoreJ2));

        Label musique = new Label("      ♫: ");
        musicPause = new Button("Pause");
        time.setFont(Font.font("Verdana", 13));
        musicPlay = new Button("Play");


        mainPane.getChildren().addAll(TopTime, TopTimeVal, TopScore, TopScoreVal1, TopScoreM, TopScoreVal2, musique
                                            , musicPause, musicPlay);
        mainPane.setStyle(" -fx-font-size: 20; -fx-background-color: #98b2ab; ");
        musicPause.setStyle("-fx-font-size: 12");
        musicPlay.setStyle("-fx-font-size: 12");
        musicPlay.setDisable(true);


        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
    }

    private void action() {
        musicPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player.pause();
                musicPlay.setDisable(false);
                musicPause.setDisable(true);
            }
        });
        musicPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player.play();
                musicPlay.setDisable(true);
                musicPause.setDisable(false);
            }
        });
    }


    public HBox getMainPane() {
        return this.mainPane;
    }
}
