package test.controller;

import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import test.module.Entity;

public class PlayerController {

    public void movingDown(Entity entity, GraphicsContext gc) {
        entity.update("down", gc);
    }
}
