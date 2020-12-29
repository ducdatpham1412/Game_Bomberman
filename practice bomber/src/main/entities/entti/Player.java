package main.entities.entti;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import main.entities.Entity;

import java.util.ArrayList;


public class Player extends Entity {


    public static final Image down01 = new Image("file:res/images/player/player01/down.png");
    public static final Image left01 = new Image("file:res/images/player/player01/left.png");
    public static final Image up01 = new Image("file:res/images/player/player01/up.png");
    public static final Image right01 = new Image("file:res/images/player/player01/right.png");
    public static final Image dead01 = new Image("file:res/images/player/player01/dead.png");

    public static final Image down02 = new Image("file:res/images/player/player02/down.png");
    public static final Image left02 = new Image("file:res/images/player/player02/left.png");
    public static final Image up02 = new Image("file:res/images/player/player02/up.png");
    public static final Image right02 = new Image("file:res/images/player/player02/right.png");

    public static final int speedMove = 2;

    public final int id;

    public ArrayList<String> hasItem = new ArrayList<>();

    public Player(double x, double y, int id) {
        super(x, y);
        this.setKind("player");
        this.id = id;
        if (id == 1) this.imgV.setImage(down01);
         else if (id==2) this.imgV.setImage(down02);
    }


    @Override
    public void update() {

    }
}
