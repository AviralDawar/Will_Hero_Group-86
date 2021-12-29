package com.example.demo1;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Animations {
    public static void transition(Node node, int from, int to, int duration){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(from);
        fade.setToValue(to);
        fade.setCycleCount(1);
        //the transition will set to be auto reversed by setting this to true
        fade.setAutoReverse(false);
        fade.setNode(node);
        //playing the transition
        fade.play();
    }
    public static void runTranslateTransition(Node n, double x, double y, double duration , boolean infinite , boolean reverse) {
        if (n == null)
            return;

        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        if(infinite){
            load.setCycleCount(TranslateTransition.INDEFINITE);
        }
        if(reverse){
            load.setAutoReverse(true);
        }
        load.setDuration(Duration.millis(duration));
        load.play();

    }
    public static void checkCollisionOrc(){
        Will will = null;
        Orc orc  = null;

        for(int i = 0 ; i<HelloController.allObjects.size() ; i ++) {
            gameElements n = HelloController.allObjects.get(i);
            if (n instanceof Will)
                will = (Will)n;
            if (n instanceof Orc)
                orc = (Orc) n;
        }
        if (will == null || orc == null) {
            System.out.println("Couldn't find both " + will + orc);
            return;
        }

        if (will.getImg().getBoundsInParent().intersects(orc.getImg().getBoundsInParent()))
            orc.getImg().setVisible(false);
            orc.setAlive(false);

            // set orc to dead
            // start fade out animation
            // fade_out_animation.onFinished(() -> {orc.dead = false; orc.teleportToNewLocation()})
            // System.out.println("Collision detected!!");
    }

    public static void checkWillFall(){
        if(HelloController.Will.getLayoutY() == 0) {
            //System.out.println("entered");
            Boolean willOnIsland = false;
            for (Island island : HelloController.islandArray) {
                if(HelloController.Will.getImg().getLayoutX()>=island.get_X() && HelloController.Will.getImg().getLayoutX()<=island.get_X() + island.getImg().getFitWidth()){
                    willOnIsland = true;
                    break;
                }
            }
            if(!willOnIsland){
                willHasDied();
            }
        }
    }
    public static void runTranslateTransitionElements(gameElements n, double x, double y, double duration , boolean infinite , boolean reverse) {
        if (n == null)
            return;

        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n.getImg());
        if(infinite){
            load.setCycleCount(TranslateTransition.INDEFINITE);
        }
        if(reverse){
            load.setAutoReverse(true);
        }
        load.setDuration(Duration.millis(duration));
        load.play();

        if (n instanceof Island) {
            load.setOnFinished(event -> {
                if (((gameElements) n).getImg().getTranslateX() + ((gameElements) n).getImg().getFitWidth() < 0) {
                    int translateBy = (int) (((gameElements) n).getImg().getTranslateX() + 90 * 15);
                    ((gameElements) n).getImg().setTranslateX(translateBy);
                    int r = 20;
                    int rand = (int) ((Math.random() - 0.5) * 2 * r);
                    ((gameElements) n).getImg().setLayoutX(rand);
                    ((Island) n).set_X(translateBy + rand);
                }
            });
        }
    }
    public static void  willHasDied(){

    }
    public static void respawnWill(){
        
    }

}
