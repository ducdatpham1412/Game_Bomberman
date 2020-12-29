package main.graphic;

import javafx.scene.Group;
import javafx.scene.Scene;
import main.graphic.pvp.BoardGame;
import main.graphic.pvp.InGame;

public class GraphicControl {

    private Group group = new Group();
    public Scene scene;

    public GraphicControl() {

        BoardGame pvp = new BoardGame();
        group.getChildren().addAll(pvp.getMainPane());

        scene = new Scene(group);
        InGame.actionPlay(scene, pvp);
    }
}
