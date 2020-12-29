package main.entities.entti;

import javafx.scene.image.Image;
import main.entities.Entity;

public class Obstacle extends Entity {

    protected static final Image gift = new Image("file:res/images/things/gift.png");
    protected static final Image tree = new Image("file:res/images/things/tree.png");
    protected static final Image olaf = new Image("file:res/images/things/olaf.png");

    public Obstacle(double x, double y, String kind) {
        super(x, y);
        this.setKind("obstacle");
        if ( kind=="gift" ) this.imgV.setImage(gift);
        else if (kind=="tree") this.imgV.setImage(tree);
        else if (kind=="olaf") this.imgV.setImage(olaf);
    }

    @Override
    public void update() {

    }
}
