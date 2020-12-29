package huy;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();

        Rectangle rec1 = new Rectangle();
        rec1.setX(50);
        rec1.setY(50);
        rec1.setWidth(100); rec1.setHeight(100);
        rec1.setFill(Color.BLUE);

        Circle c1 = new Circle();
        c1.setCenterX(100); c1.setCenterY(50);
        c1.setRadius(30);
        c1.setFill(Color.RED);

        Shape shape = Shape.intersect(rec1, c1);
        shape.setFill(Color.GREEN);

        root.getChildren().addAll(rec1, c1, shape);

        System.out.println(shape.getBoundsInLocal().getMinX() + " - " + shape.getLayoutY());

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
