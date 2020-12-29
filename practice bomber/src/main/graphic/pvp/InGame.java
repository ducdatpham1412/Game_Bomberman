package main.graphic.pvp;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import main.controller.MapController;
import main.controller.PlayerController;
import main.entities.Entity;
import main.entities.entti.*;

import java.util.ArrayList;
import java.util.Random;

public class InGame  {

    /*
    * InGame is a Pane include a GridPane
    * */
    private Pane mainPane = new Pane();

    private Player player01, player02;
    private boolean movingLeft, movingUp, movingRight, movingDown;



    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Shadow> shadows = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Obstacle> obstacles = new ArrayList<>(); //obstacles used to save tree, gift or olaf
    private ArrayList<Shadow> shadowObstacles = new ArrayList<>();

    private ArrayList<Entity> notGoThrough = new ArrayList<>();

    private PlayerController playerController = new PlayerController();
    private MapController mapController = new MapController();


    public static final int rows = 11;
    public static final int columns = 21;


    //Constructor
    public InGame() {

       initialize();
       drawImage();
    }


    /*
    * Functions support Constructor
    * */
    private void initialize() {

//        Initialize wall and grass
        for (int y=0; y<rows; y++) {
            for (int x=0; x<columns; x++) {

                if ( x==0 || y==0 || x==columns-1 || y==rows-1 ) {

                    Wall temptWall = new Wall(x, y);
                    walls.add(temptWall);
                    notGoThrough.add(temptWall);
                    if (y!=0) {
                        Shadow temptShadow = new Shadow(x, y-0.5, "wall");
                        shadows.add(temptShadow);
                    }
                }
                else {
                    if ( x%2==1 ) {
                        Grass temptGrass = new Grass(x, y, "light");
                        grasses.add(temptGrass);
                    }
                    else if ( x%2==0 ) {
                        Grass temptGrass = new Grass(x, y, "dark");
                        grasses.add(temptGrass);
                    }
                }
            }
        }

        // Init wall and obstacles inside game
        for (int y=1; y<rows-1; y++) {
            for (int x=1; x<columns-1; x++) {

                if ( (x==4||x==6||x==8||x==12||x==14||x==16) && (y==2||y==4||y==6||y==8) ) {

                    Wall temptWall = new Wall(x, y);
                    walls.add(temptWall);
                    notGoThrough.add(temptWall);
                    Shadow temptShadow = new Shadow(x, y-0.5, "wall");
                    shadows.add(temptShadow);
                }
                else {
                    if ( (x==1&&y==1) || (x==2&&y==1) || (x==1&&y==2) ) continue;

                    Random random = new Random();
                    int a = random.nextInt(3)+1;
                    if (a==1) {
                        Obstacle tempt = new Obstacle(x, y, "gift");
                        obstacles.add(tempt);
                        notGoThrough.add(tempt);
                        Shadow temptShadow = new Shadow(x, y-0.5, "gift");
                        shadowObstacles.add(temptShadow);
                        shadows.add(temptShadow);
                    }
                    else if (a==2) {
                        Obstacle tempt = new Obstacle(x, y, "tree");
                        obstacles.add(tempt);
                        notGoThrough.add(tempt);
                        Shadow temptShadow = new Shadow(x, y-0.5, "tree");
                        shadowObstacles.add(temptShadow);
                        shadows.add(temptShadow);
                    }
                    else if (a==3) {
                        Obstacle tempt = new Obstacle(x, y, "olaf");
                        obstacles.add(tempt);
                        notGoThrough.add(tempt);
                        Shadow temptShadow = new Shadow(x, y-0.5, "olaf");
                        shadowObstacles.add(temptShadow);
                        shadows.add(temptShadow);
                    }
                }
            }
        }

//        Init player
        player01 = new Player(1, 1, 1);
    }




    private void drawImage() {


        for (Grass grass: grasses) {
            grass.render(mainPane);
        }

        for (Wall wall: walls) {
            wall.render(mainPane);
        }

        for (Obstacle obstacle: obstacles) {
            obstacle.render(mainPane);
        }

        player01.render(mainPane);

        for (Entity entity: shadows) {
            entity.render(mainPane);
        }

    }



    /*
    * Function control action of player
    * */
    public static void actionPlay(Scene scene, BoardGame boardGame) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case A:
                        boardGame.getInGame().movingLeft = true;
                        break;
                    case W:
                        boardGame.getInGame().movingUp = true;
                        break;
                    case D:
                        boardGame.getInGame().movingRight = true;
                        break;
                    case S:
                        boardGame.getInGame().movingDown = true;
                        break;
                    case M:
                        boardGame.getInGame().mapController.setBomb(boardGame.getInGame().player01,
                                boardGame.getInGame());
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case A:
                        boardGame.getInGame().movingLeft = false;
                        break;
                    case W:
                        boardGame.getInGame().movingUp = false;
                        break;
                    case D:
                        boardGame.getInGame().movingRight = false;
                        break;
                    case S:
                        boardGame.getInGame().movingDown = false;
                        break;
                }
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                String command="";
                if (boardGame.getInGame().movingLeft) {
                    command = "left";
                }
                else if (boardGame.getInGame().movingUp) {
                    command = "up";
                }
                else if (boardGame.getInGame().movingRight) {
                    command = "right";
                }
                else if (boardGame.getInGame().movingDown) {
                    command = "down";
                }

                boardGame.getInGame().playerController.movingCharacter(boardGame.getInGame().player01, command, boardGame.getInGame().notGoThrough);
            }
        };
        timer.start();
    }


    /*
    * Functions getter, setter
    * */

    public Pane getMainPane() {
        return mainPane;
    }

    public ArrayList<Entity> getNotGoThrough() {
        return notGoThrough;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public ArrayList<Shadow> getShadowObstacles() {
        return shadowObstacles;
    }

    public ArrayList<Shadow> getShadows() {
        return shadows;
    }
}







//    private void initWall(String pathWall) {
//
//        File file = new File(pathWall);
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line;
//            while ( (line=reader.readLine())!=null ) {
//                String[] tempt = line.split("\t");
//                int x = Integer.parseInt(tempt[0]);
//                int y = Integer.parseInt(tempt[1]);
//                String path = tempt[2];
//
//                Wall wallTempt = new Wall(x, y, path);
//                walls.add(wallTempt);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void drawWall() {
//        for (Wall wall: walls) {
//            wall.render(mainPane);
//        }
//    }
