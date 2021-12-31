package com.example.demo1;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

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

        fade.play();
    }
    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration , boolean infinite , boolean reverse) {
        //if (((gameElements) n).getAlive()){
            if (n == null) {
                return null;
            }
            TranslateTransition load = new TranslateTransition();
            load.setByY(y);
            load.setByX(x);
            load.setNode(n);
            if (infinite) {
                load.setCycleCount(TranslateTransition.INDEFINITE);
            }
            if (reverse) {
                load.setAutoReverse(true);
            }
            load.setDuration(Duration.millis(duration));
            load.play();
            return load;
        //}
    }
    public static Boolean deathByOrc = false;
    public static ParallelTransition rotateAndTranslate(Node n, double x, double y, double duration , boolean infinite , boolean reverse){
        if (n == null) {
            return null;
        }
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
        RotateTransition rotate = new RotateTransition();
        rotate.setFromAngle(0);
        rotate.setToAngle(359);
        rotate.setNode(n);
        rotate.setDuration(Duration.millis(200));
        rotate.setCycleCount(4);
        ParallelTransition allTransitions = new ParallelTransition(load , rotate);
        allTransitions.play();
        return allTransitions;
    }
    public static void checkCollisionOrc() throws InterruptedException {
        for(Orc orc : HelloController.orcArrayList) {
            if (HelloController.Will.getImg().getBoundsInParent().intersects(orc.getImg().getBoundsInParent())) {
//                System.out.println("will " + HelloController.Will.getImg().getTranslateY());
//                System.out.println("orc " + orc.getImg().getTranslateY());
//                orc.getImg().setTranslateY(HelloController.Will.getImg().getTranslateY() -28);
                if (HelloController.Will.getImg().getTranslateY() > orc.getImg().getTranslateY() + 28) {
                    //System.out.println();

                    deathByOrc = true;
                    willHasDied(2500);
                    // this function should only be implemented 1 time
                    // pause the whole game for some time
                } else if (HelloController.Will.getImg().getTranslateX() + HelloController.Will.getImg().getLayoutX() < orc.getImg().getTranslateX() + orc.getImg().getLayoutX() - 30) {
                    System.out.println("orcPushed");
                    pushOrc(orc);
                } else {
                    willOnOrc();
                }
            }
        }
    }


    public static void checkWillFall(){
        while (HelloController.Will.isAlive) {
            if (HelloController.Will.getImg().getTranslateY() > -5) {
                Boolean willOnIsland = false;
                for (Island island : HelloController.islandArray) {
                    ImageView will = HelloController.Will.getImg();
                    if (will.getLayoutX() + will.getFitWidth() - 13>= island.get_X() && will.getLayoutX()-13 <= (island.get_X() + island.getImg().getFitWidth())) {
                        willOnIsland = true;
                        break;
                    }
                }
                if (!willOnIsland) {
                    System.out.println("Will has died");
                    willHasDied(1);
                }
            }
        }
    }
    public static void checkOrcFall(){
        while(true) {
            String fallingOrc = null;
            Boolean orcOnIsland = true;
            for (Orc orc : HelloController.orcArrayList) {
                if (orc.getImg().getTranslateY() > -5) {
                    for (Island island : HelloController.islandArray) {
                        ImageView orcImg = orc.getImg();
                        if (orcImg.getLayoutX() + orcImg.getFitWidth() - 13 <= island.get_X() || orcImg.getLayoutX() - 13 >= (island.get_X() + island.getImg().getFitWidth())) {
//                            orcOnIsland = false;
//                            fallingOrc = orc.getType();
                            break;
                        }
                    }
                    if (!orcOnIsland) {
                        System.out.println(fallingOrc);
                        orcFall();
                    }
                }
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
    public static void  willHasDied(int duration) {
        if (HelloController.Will.isAlive) {
            HelloController.Will.isAlive = false;
            Timeline temp = null;
            for(TranslateTransition bobbing : HelloController.bobbing){
                bobbing.stop();
                temp = new Timeline(new KeyFrame(Duration.millis(duration), ae -> {bobbing.play();}));
                temp.play();
            }
            temp.setOnFinished(actionEvent -> {ParallelTransition t = Animations.rotateAndTranslate(HelloController.Will.getImg(), 0, 300, 2500, false, false);
                Animations.runTranslateTransition(HelloController.respawnMenu.getRespawnMenu(), 0, -550, 1000, false, false);
                t.setOnFinished(actionEvent2 -> {
                    move_Back(-360 , 1);
                    HelloController.Will.setAlive(true);
                    HelloController.Will.getImg().setTranslateY(0);
                });});
        }
    }
    public static void respawnWill(){

    }
    public static void pushOrc(Orc orc){
        runTranslateTransition(orc.getImg() , 100 , 0 , 100 , false , false);
    }
    public static void move_Back(int moveBy , int duration){
        if (!HelloController.pauseMenuUp) {
            for (gameElements element : HelloController.allObjects) {
                if (element instanceof Will)
                    continue;
                Animations.runTranslateTransitionElements(element, moveBy, 0, duration, false, false);
            }
//            for(Island island : islandArray) {
//                island.position[0] = island.position[0] - 90;
//                System.out.println(island.position[0]);
//                System.out.println(island.position[0] + island.getFitWidth());
//            }
            HelloController.islandArray[0].set_X(HelloController.islandArray[0].get_X() +moveBy);
            HelloController.islandArray[1].set_X(HelloController.islandArray[1].get_X() +moveBy);
            HelloController.islandArray[2].set_X(HelloController.islandArray[2].get_X() +moveBy);
            HelloController.islandArray[3].set_X(HelloController.islandArray[3].get_X() +moveBy);
        }
    }
    public static void willOnOrc(){

    }
    public static void orcFall(){

    }

}
