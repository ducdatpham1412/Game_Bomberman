package huy;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class BoardGame {

    private Pane pane;

    private GraphicsContext gc;
    private Canvas canvas;

    public BoardGame() {

        initalize();
    }

    private void initalize() {

        canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();

        Image image = new Image("file:res/images/original/olaf.jpg");

        gc.drawImage(image, 0, 0);

        pane = new Pane();
        pane.getChildren().addAll(canvas);
    }


    public Pane getPane() {
        return pane;
    }
}
