package main.controller;

import main.entities.Entity;
import main.entities.entti.Player;

import java.util.ArrayList;

public class PlayerController {

    private boolean ALIVE = true;

    /* ---------------------------------------------------
    * Functions for moving player
    *  --------------------------------------------------- */

    private void setImage(Player player, String command) {

        if ( player.id==1 ) {
            switch (command) {
                case "left": player.getImgV().setImage(Player.left01); break;
                case "up": player.getImgV().setImage(Player.up01); break;
                case "right": player.getImgV().setImage(Player.right01); break;
                case "down": player.getImgV().setImage(Player.down01); break;
            }
        } else if ( player.id==2 ) {
            switch (command) {
                case "left": player.getImgV().setImage(Player.left01); break;
                case "up": player.getImgV().setImage(Player.up01); break;
                case "right": player.getImgV().setImage(Player.right01); break;
                case "down": player.getImgV().setImage(Player.down01); break;
            }
        }
    }


    public void movingCharacter(Player player, String command, ArrayList<Entity> notGoThrough) {

        if (ALIVE) {
            this.setImage(player, command);

            double x = player.getImgV().getLayoutX();
            double y = player.getImgV().getLayoutY();

            switch (command) {

                case "left":
                    x -= Player.speedMove;
                    player.getImgV().relocate(x, y);
                    for (Entity entity: notGoThrough) {
                        if (player.impactWith(entity, command)) {
//                            System.out.println("player impact with: " + entity.getKind());
                            x += Player.speedMove;
                            if ( Math.abs(player.getMoveToLand()) <= 20 ) {
                                if ( player.getMoveToLand()>0 ) y += Player.speedMove;
                                else if ( player.getMoveToLand()<0 ) y-= Player.speedMove;
                            }
                            player.setMoveToLand(0);
                            player.getImgV().relocate(x, y);
                            return;
                        }
                    }
                    break;

                case "right":
                    x += Player.speedMove;
                    player.getImgV().relocate(x, y);
                    for (Entity entity: notGoThrough) {
                        if (player.impactWith(entity, command)) {
//                            System.out.println("player impact with: " + entity.getKind() + " at " + notGoThrough.indexOf(entity));
                            x -= Player.speedMove;
                            if ( Math.abs(player.getMoveToLand()) <= 20 ) {
                                if ( player.getMoveToLand()>0 ) y += Player.speedMove;
                                else if ( player.getMoveToLand()<0 ) y-= Player.speedMove;   /**/
                            }
                            player.setMoveToLand(0);
                            player.getImgV().relocate(x, y);
                            return;
                        }
                    }
                    break;

                case "down":
                    y += Player.speedMove;
                    player.getImgV().relocate(x, y);
                    for (Entity entity: notGoThrough) {
                        if (player.impactWith(entity, command)) {
//                            System.out.println("player impact with: " + entity.getKind());
                            y -= Player.speedMove;
                            if ( Math.abs(player.getMoveToLand()) <= 20 ) {
                                if ( player.getMoveToLand()>0 ) x += Player.speedMove;
                                else if ( player.getMoveToLand()<0 ) x -= Player.speedMove;
                            }
                            player.setMoveToLand(0);
                            player.getImgV().relocate(x, y);
                            return;
                        }
                    }
                    break;

                case "up":
                    y -= Player.speedMove;
                    player.getImgV().relocate(x, y);
                    for (Entity entity: notGoThrough) {
                        if (player.impactWith(entity, command)) {
//                            System.out.println("player impact with: " + entity.getKind());
                            y += Player.speedMove;
                            if ( Math.abs(player.getMoveToLand()) <= 20 ) {
                                if ( player.getMoveToLand()>0 ) x += Player.speedMove;
                                else if ( player.getMoveToLand()<0 ) x -= Player.speedMove;
                            }
                            player.setMoveToLand(0);
                            player.getImgV().relocate(x, y);
                            return;
                        }
                    }
                    break;
            }
        }

    }


    /* ---------------------------------------------------
     *
     * --------------------------------------------------- */

}
