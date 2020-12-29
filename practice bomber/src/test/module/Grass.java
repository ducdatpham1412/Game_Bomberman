package test.module;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Grass extends Entity {


    public Grass(int x, int y) {
        super(x, y);
        this.img = new Image("file:res/images/grassLight.jpg");
    }

    public Grass(int x, int y, String kind) {
        super(x, y);
        if ( kind=="light" ) this.img = new Image("file:res/images/grassLight.jpg");
         else if (kind=="dark") this.img = new Image("file:res/images/grassDark.jpg");
    }

    @Override
    public void update(String command, GraphicsContext gc) {

    }
}
