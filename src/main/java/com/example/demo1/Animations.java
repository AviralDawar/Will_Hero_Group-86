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

        if (n.getId().startsWith("island"))
            load.setOnFinished(event -> {
                if (n.getTranslateX() + ((ImageView)n).getFitWidth() < 0) {
                    n.setTranslateX(n.getTranslateX() + 90 * 15);
                    // if you want randomness of +- x
                    int r = 20;
                    n.setLayoutX((Math.random() - 0.5) * 2 * r);

                }
            });
    }
    public static void checkCollisionOrc(){
        Node will = null;
        Node orc = null;

        for(int i = 0 ; i<HelloController.allObjects.size() ; i ++) {
            Node n = HelloController.allObjects.get(i);
            if (n.getId().equals("will"))
                will = n;
            if (n.getId().endsWith("Orc"))
                orc = n;
        }
        if (will == null || orc == null) {
            System.out.println("Couldnt find both " + will + orc);
            return;
        }

//        System.out.println("Detecting collision");

        if (will.getBoundsInParent().intersects(orc.getBoundsInParent()))
            orc.setVisible(false);
            // set orc to dead
            // start fade out animation
            // fade_out_animation.onFinished(() -> {orc.dead = false; orc.teleportToNewLocation()})
            //System.out.println("Collision detected!!");
    }
}
