package main.entities.entti;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.entities.Entity;


public class Wall extends Entity {

    protected static final Image wall = new Image("file:res/images/things/wall.png");


    public Wall(double x, double y) {
        super(x, y);
        this.setKind("wall");
        this.imgV.setImage(wall);
    }

    @Override
    public void update() {

    }
}
