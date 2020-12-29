package test.module;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import test.graphic.InGame;


public class Player extends Entity {

    final static Image player00 = new Image("file:res/images/player/01.jpg");
    final static Image player01 = new Image("file:res/images/player/01.jpg");
    final static Image player02 = new Image("file:res/images/player/01.jpg");
    final static Image player03 = new Image("file:res/images/player/01.jpg");

    public Player(int x, int y) {
        super(x, y);
        this.img = player00;
    }

    @Override
    public void update(String command, GraphicsContext gc) {

        if (command=="down") {
            Timeline t = new Timeline();
            t.setCycleCount(Timeline.INDEFINITE);

            t.getKeyFrames().add(new KeyFrame(
                    Duration.seconds(0.5),
                    (ActionEvent event) -> {

                        int _x = this.x/(int)Entity.default_size;
                        int _y = this.y/(int)Entity.default_size;

                        this.y += 10;
                        this.img = player01;
                        InGame.entities[_y][_x].render(gc);
                        this.render(gc);
                    }
            ));
            t.getKeyFrames().add(new KeyFrame(
                    Duration.seconds(1),
                    (ActionEvent event) -> {

                        int _x = this.x/(int)Entity.default_size;
                        int _y = this.y/(int)Entity.default_size;

                        this.y += 10;
                        this.img = player02;
                        InGame.entities[_y][_x].render(gc);
                        this.render(gc);
                    }
            ));
            t.getKeyFrames().add(new KeyFrame(
                    Duration.seconds(1.5),
                    (ActionEvent event) -> {

                        int _x = this.x/(int)Entity.default_size;
                        int _y = this.y/(int)Entity.default_size;

                        this.y += 10;
                        this.img = player03;
                        InGame.entities[_y][_x].render(gc);
                        this.render(gc);
                    }
            ));
            t.getKeyFrames().add(new KeyFrame(
                    Duration.seconds(2),
                    (ActionEvent event) -> {

                        int _x = this.x/(int)Entity.default_size;
                        int _y = this.y/(int)Entity.default_size;

                        this.y += 10;
                        this.img = player00;
                        InGame.entities[_y][_x].render(gc);
                        this.render(gc);
                    }
            ));

            t.play();

            TranslateTransition transition = new TranslateTransition();
            this.imgV = new ImageView(this.img);
            transition.setDuration(Duration.millis(10000));
            transition.setNode(imgV);
        }
     }
}
