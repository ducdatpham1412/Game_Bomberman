package test.graphic;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import test.controller.PlayerController;
import test.module.*;


public class InGame {

    public static final int rows = 10;
    public static final int collums = 17;

    public static Entity[][] entities = new Entity[rows][collums];

    private PlayerController playerController;

    private Canvas canvas;
    private GraphicsContext gc;


    private Entity wall, grass;
    private Entity player;

    public InGame() {
        initialize();
        action();
    }

    private void initialize() {

        playerController = new PlayerController();

        canvas = new Canvas(Entity.default_size*collums, Entity.default_size*rows);
        gc = canvas.getGraphicsContext2D();

        for (int y=0; y<rows; y++) {
            for (int x=0; x<collums; x++) {
                if ( y==0 || x==0 || y==rows-1 || x==collums-1 || ( (y==3||y==6)&&(x==3||x==6||x==8||x==10||x==13) ) ) {
                    wall = new Wall(x, y);
                    entities[y][x] = wall;
                    wall.render(gc);
                }
                else if ( x%2==0 ) {
                    grass = new Grass(x, y, "dark");
                    entities[y][x] = grass;
                    grass.render(gc);
                }
                else {
                     grass = new Grass(x, y, "light");
                     entities[y][x] = grass;
                     grass.render(gc);
                }
            }
        }

        player = new Player(1, 1);
        player.render(gc);
    }

    private void action() {

        playerController.movingDown(player, gc);
    }


    public Canvas getPaneGame() {
        return this.canvas;
    }

}
