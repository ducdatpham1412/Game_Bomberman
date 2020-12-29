package main.entities.entti;

import javafx.scene.image.Image;
import main.entities.Entity;

public class Shadow extends Entity {

    protected static final Image shadowWall = new Image("file:res/images/things/wallShadow.png");
    protected static final Image shadowGift = new Image("file:res/images/things/giftShadow.png");
    protected static final Image shadowTree = new Image("file:res/images/things/treeShadow.png");
    protected static final Image shadowOlaf = new Image("file:res/images/things/olafShadow.png");


    public Shadow(double x, double y, String kind) {
        super(x, y);
        if (kind=="wall") this.imgV.setImage(shadowWall);
        else if (kind=="gift") this.imgV.setImage(shadowGift);
        else if (kind=="tree") this.imgV.setImage(shadowTree);
        else if (kind=="olaf") this.imgV.setImage(shadowOlaf);
    }

    @Override
    public void update() {

    }
}
