package main.entities;


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public abstract class Entity {

    /*
    * kind used to know what this entity is (contain wall, obstacle, bomb and player)
    * */

    private String kind = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        if (this.kind==null) this.kind = kind;
        else System.out.println("Can't change kind of entity");
    }
    /*
    * Location of Entity with x and y
    * */

    protected double x;
    protected double y;
    
    /*
    * Each Entity has own pane including imageview
    * */
    protected ImageView imgV;


    //Size default of element in game
    public final static double default_size = 50;

    /* -----------------------------------------------
    * Constructor and Function render
    *  -----------------------------------------------  */
    public Entity(double x, double y) {
        this.imgV = new ImageView();
        this.x = x*default_size;
        this.y = y*default_size;
    }


    public void render(Pane pane, int index) {
        pane.getChildren().add(index, this.imgV);
        this.imgV.setLayoutX(x);
        this.imgV.setLayoutY(y);
    }
    public void render(Pane pane) {
        pane.getChildren().add(this.imgV);
        this.imgV.setLayoutX(x);
        this.imgV.setLayoutY(y);
    }

    private int moveToLand;

    public int getMoveToLand() {
        return moveToLand;
    }
    public void setMoveToLand(int moveToLand) {
        this.moveToLand = moveToLand;
    }

    public boolean impactWith(Entity entity) {

        Rectangle recThis = new Rectangle(this.getImgV().getLayoutX()+1, this.getImgV().getLayoutY()+1,
                this.getImgV().getBoundsInLocal().getWidth()-2, this.getImgV().getBoundsInLocal().getHeight()-2);

        Rectangle recEntity = new Rectangle(entity.getImgV().getLayoutX(), entity.getImgV().getLayoutY(),
                entity.getImgV().getImage().getWidth(), entity.getImgV().getImage().getHeight());

        return recThis.intersects(recEntity.getBoundsInLocal());
    }

    public boolean impactWith(Entity entity, String command) {

        Rectangle recThis = new Rectangle(this.getImgV().getLayoutX(), this.getImgV().getLayoutY() + 15,
                this.getImgV().getImage().getWidth(), this.getImgV().getImage().getHeight() - 15);

        Rectangle recEntity = new Rectangle(entity.getImgV().getLayoutX(), entity.getImgV().getLayoutY(),
                entity.getImgV().getImage().getWidth(), entity.getImgV().getImage().getHeight());

        Shape rec3 = Shape.intersect(recThis, recEntity);

//
//        System.out.println("RecPlayer: " + recThis.getX() + " - " + recThis.getY());
//        System.out.println("Rec3:      " + rec3.getBoundsInLocal().getMinX() + " - " + rec3.getBoundsInLocal().getMinY() + " / " + rec3.getBoundsInLocal().getWidth() + " - " + rec3.getBoundsInLocal().getHeight());

        if ( rec3.getBoundsInLocal().getWidth()>0 || rec3.getBoundsInLocal().getHeight()>0 ) {

            switch (command) {
                case "left":
                    if ( rec3.getBoundsInLocal().getMinY() == recThis.getY() ) moveToLand = (int)rec3.getBoundsInLocal().getHeight();
                    else moveToLand = -(int)rec3.getBoundsInLocal().getHeight();
                    break;
                case "right":
                    if ( rec3.getBoundsInLocal().getMinY() == recThis.getY() ) moveToLand = (int)rec3.getBoundsInLocal().getHeight();
                    else moveToLand = -(int)rec3.getBoundsInLocal().getHeight();
                    break;
                case "down":
                    if ( rec3.getBoundsInLocal().getMinX() == recThis.getX() ) moveToLand = (int)rec3.getBoundsInLocal().getWidth();
                    else moveToLand = -(int)rec3.getBoundsInLocal().getWidth();
                    break;
                case "up":
                    if ( rec3.getBoundsInLocal().getMinX() == recThis.getX() ) moveToLand = (int)rec3.getBoundsInLocal().getWidth();
                    else moveToLand = -(int)rec3.getBoundsInLocal().getWidth();
                    break;
            }
            return true;
        }

        return false;
    }


    /* -------------------------------------
    *
    *  -------------------------------------*/



    /*
    * Function update for moving or update status entity in map
    * */
    public abstract void update();

    /*
    * Function getter, setter
    * */
    public ImageView getImgV() {
        return imgV;
    }
}
