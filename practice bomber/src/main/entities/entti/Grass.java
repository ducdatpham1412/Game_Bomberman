package main.entities.entti;

import javafx.scene.image.Image;
import main.entities.Entity;

public class Grass extends Entity {

    protected static final Image grassDark = new Image("file:res/images/things/grassDark.jpg");
    protected static final Image grassLight = new Image("file:res/images/things/grassLight.jpg");

    public Grass(double x, double y, String kind) {
        super(x, y);
        if ( kind=="dark" ) this.imgV.setImage(grassDark);
         else if ( kind=="light" ) this.imgV.setImage(grassLight);
    }

    @Override
    public void update() {

    }
}
