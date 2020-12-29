package test.module;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import test.controller.MapController;
import test.lib.Sprite;

public abstract class Entity {

    //x và y là vị trí của vật
    protected int x;
    protected int y;
    public static final double default_size=50;

    protected Image img;
    protected ImageView imgV;


    public Entity(int x, int y) {
        this.x = x * (int)Entity.default_size;
        this.y = y * (int)Entity.default_size;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(this.img, x, y);
    }

    public abstract void update(String command, GraphicsContext gc);
}
