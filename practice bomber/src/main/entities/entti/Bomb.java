package main.entities.entti;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.util.Duration;
import main.entities.Entity;

public class Bomb extends Entity {

    public static final Image bomb = new Image("file:res/images/bombs/bomb.png");
    public static final Image bombLeft = new Image("file:res/images/bombs/bombLeft.png");
    public static final Image bombRight = new Image("file:res/images/bombs/bombRight.png");
    public static final Image bombDown = new Image("file:res/images/bombs/bombDown.png");
    public static final Image bombUp = new Image("file:res/images/bombs/bombUp.png");

    public Bomb(double x, double y, String kind) {
        super(x, y);
        this.setKind("bomb");
        if (kind=="bomb") this.imgV.setImage(bomb);
        else if (kind=="bombLeft") this.imgV.setImage(bombLeft);
        else if (kind=="bombRight") this.imgV.setImage(bombRight);
        else if (kind=="bombDown") this.imgV.setImage(bombDown);
        else if (kind=="bombUp") this.imgV.setImage(bombUp);
    }

    @Override
    public void update() {

    }
}
