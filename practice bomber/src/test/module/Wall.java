package test.module;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Wall extends Entity {


    public Wall(int x, int y) {
        super(x, y);
        this.img = new Image("file:res/images/wall.jpg");
    }

    @Override
    public void update(String command, GraphicsContext gc) {

    }
}
