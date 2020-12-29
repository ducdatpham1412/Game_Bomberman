package test.controller;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import test.module.Entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MapController {

    public void resize(Image input, double size) {

        final int width = (int) input.getWidth();
        final int height = (int) input.getHeight();

        int scale = (int)size/width;

        WritableImage output = new WritableImage((int)size, (int)size);

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y=0; y<height; y++) {
            for (int x = 0; x < width; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < scale; dy++) {
                    for (int dx = 0; dx < scale; dx++) {
                        writer.setArgb(x * scale + dx, y * scale + dy, argb);
                    }
                }
            }
        }

        input = output;
    }

}
