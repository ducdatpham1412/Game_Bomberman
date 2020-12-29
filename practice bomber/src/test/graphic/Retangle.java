package test.graphic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Retangle {

    public Pane pane = null;
    public Image img = null;
    public ImageView imgV = null;

    public Retangle() {

        this.img = new Image("file:res/images/grassLight.jpg");
        this.imgV = new ImageView(img);
        this.imgV.setFitHeight(50);
        this.imgV.setFitWidth(50);

        pane = new Pane();
        pane.getChildren().addAll(imgV);
    }



    public void setImage(Image tempt) {
       this.imgV.setImage(tempt);
    }
}
