package main.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.entities.Entity;
import main.entities.entti.Bomb;
import main.entities.entti.Player;
import main.entities.entti.Shadow;
import main.graphic.pvp.InGame;

import java.io.File;
import java.util.Collections;

public class MapController {

    /*
    * FUNCTION SET BOMB FROM SET TO BANG
    * */
    public void setBomb(Player player, InGame inGame) {

        double x = (int)((player.getImgV().getLayoutX() + player.getImgV().getBoundsInLocal().getWidth()/2) / Entity.default_size);
        double y = (int)((player.getImgV().getLayoutY() + player.getImgV().getBoundsInLocal().getHeight()/2) / Entity.default_size);

        Bomb bomb = new Bomb(x, y, "bomb");
        Bomb bombLeft = new Bomb(x-1, y, "bombLeft");
        Bomb bombRight = new Bomb(x, y, "bombRight");
        Bomb bombDown = new Bomb(x, y, "bombDown");
        Bomb bombUp = new Bomb(x, y-1, "bombUp");

        Timeline time = new Timeline();
        time.setCycleCount(1);

        Bomb finalBomb = bomb;
        Bomb finalBombLeft = bombLeft;
        Bomb finalBombRight = bombRight;
        Bomb finalBombDown = bombDown;
        Bomb finalBombUp = bombUp;

        /*
        * TIME USED TO UPDATE FROM SETBOMB FROM BOMB BANG
        * */

        time.getKeyFrames().add(new KeyFrame(
                Duration.seconds(0),
                (ActionEvent event) -> {
                    finalBomb.render(inGame.getMainPane());
                    /*
                    * Loop FOR under have mission if set bomb behind shadow, swap index of shadow and bomb
                    * */
                    for (Shadow shadow: inGame.getShadows()) {
                        if ( finalBomb.impactWith(shadow) ) {
                           int one = inGame.getMainPane().getChildren().indexOf(finalBomb.getImgV());
                           int two = inGame.getMainPane().getChildren().indexOf(shadow.getImgV());
                           ObservableList<Node> tempt = FXCollections.observableArrayList(inGame.getMainPane().getChildren());
                           Collections.swap(tempt, one, two);
                           inGame.getMainPane().getChildren().setAll(tempt);
                        }
                    }
                    /*________________________________________________________
                    * */
                }
        ));

        time.getKeyFrames().add(new KeyFrame(
                Duration.seconds(3),
                (ActionEvent event) -> {

                    MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("res/music/bomb.mp3").toURI().toString()));
                    mediaPlayer.setAutoPlay(true);

                    finalBomb.getImgV().setImage(null);
                    finalBombLeft.render(inGame.getMainPane());
                    finalBombRight.render(inGame.getMainPane());
                    finalBombDown.render(inGame.getMainPane());
                    finalBombUp.render(inGame.getMainPane());

                    /*
                    * If bomb bang impact with wall, bomb will not disappear
                    * */
                    for (Entity entity: inGame.getNotGoThrough()) {
                        if ( entity.getKind()=="wall" ) {
                            if ( finalBombLeft.impactWith(entity) ) {
                                finalBombLeft.getImgV().setImage(null);
                            }
                            else if ( finalBombRight.impactWith(entity) ) {
                                finalBombRight.getImgV().setImage(null);
                            }
                            else if ( finalBombUp.impactWith(entity) ) {
                                finalBombUp.getImgV().setImage(null);
                            }
                            else if ( finalBombDown.impactWith(entity) ) {
                                finalBombDown.getImgV().setImage(null);
                            }
                        }
                    }

                    /*
                    * If bomb bang impact with obstacle, it will disappear, remove both in OBSTACLES and SHADOW ArrayList
                    * */
                    for (Entity entity: inGame.getObstacles()) {
                        if ( entity.getKind()=="obstacle" ) {
                            if (finalBombLeft.impactWith(entity)) {
                                inGame.getMainPane().getChildren().remove(entity.getImgV());
                                int index = inGame.getObstacles().indexOf(entity);
                                inGame.getMainPane().getChildren().remove(inGame.getShadowObstacles().get(index).getImgV());
                                inGame.getNotGoThrough().remove(entity);
                            }
                            if (finalBombRight.impactWith(entity)) {
                                inGame.getMainPane().getChildren().remove(entity.getImgV());
                                int index = inGame.getObstacles().indexOf(entity);
                                inGame.getMainPane().getChildren().remove(inGame.getShadowObstacles().get(index).getImgV());
                                inGame.getNotGoThrough().remove(entity);
                            }
                            if (finalBombUp.impactWith(entity)) {
                                inGame.getMainPane().getChildren().remove(entity.getImgV());
                                int index = inGame.getObstacles().indexOf(entity);
                                inGame.getMainPane().getChildren().remove(inGame.getShadowObstacles().get(index).getImgV());
                                inGame.getNotGoThrough().remove(entity);
                            }
                            if (finalBombDown.impactWith(entity)) {
                                inGame.getMainPane().getChildren().remove(entity.getImgV());
                                int index = inGame.getObstacles().indexOf(entity);
                                inGame.getMainPane().getChildren().remove(inGame.getShadowObstacles().get(index).getImgV());
                                inGame.getNotGoThrough().remove(entity);
                            }
                        }
                    }
                    /* ______________________________________________________________________
                    * */
                }
        ));

        time.getKeyFrames().add(new KeyFrame(
                Duration.seconds(3.2),
                (ActionEvent event) -> {
                    finalBombLeft.getImgV().setImage(null);
                    finalBombRight.getImgV().setImage(null);
                    finalBombDown.getImgV().setImage(null);
                    finalBombUp.getImgV().setImage(null);
                }
        ));
        time.play();
        /* ________________________________________
        * BOMB BANG
        *  ________________________________________*/
    }
    /*
    * FUNCTIONS SET BOMB _ ENDING
    * */
}
