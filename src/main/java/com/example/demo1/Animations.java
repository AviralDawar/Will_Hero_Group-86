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
        rotate.setCycleCount(10);
        ParallelTransition allTransitions = new ParallelTransition(load , rotate);
        allTransitions.play();
        return allTransitions;
    }
    public static void checkCollisionOrc() throws InterruptedException {
        Boolean orcPushed = false;
        for(Orc orc : HelloController.orcArrayList) {
            if (HelloController.Will.getImg().getBoundsInParent().intersects(orc.getImg().getBoundsInParent())) {
                if(!HelloController.Will.getHasWeapon() || (HelloController.Will.getHasWeapon() && HelloController.Will.getWeapon().getPower() == 0)) {
                    if (HelloController.Will.getImg().getTranslateY() > orc.getImg().getTranslateY() + 28 && !(HelloController.Will.getImg().getTranslateX() + HelloController.Will.getImg().getLayoutX() < orc.getImg().getTranslateX() + orc.getImg().getLayoutX() - 30)) {
                        deathByOrc = true;
                        HelloController.clickToPlayActivated = false;
                        willHasDied(2500);
                    } else if (HelloController.Will.getImg().getTranslateX() + HelloController.Will.getImg().getLayoutX() < orc.getImg().getTranslateX() + orc.getImg().getLayoutX() - 30) {
                        //                    System.out.println("orcPushed" + orc.getType());
                        pushOrc(orc);
                    } else {pushOrc(orc);}
                }
                else{
                    orc.getImg().setTranslateX(90*15);
                }
            }
        }
    }

    public static void checkCoinCollision(){
        for(Coin coin:HelloController.coinList) {
            if (HelloController.Will.getImg().getBoundsInParent().intersects(coin.getImg().getBoundsInParent())) {
                //coin.getImg().setVisible(false);
                HelloController.updateCoins(coin);
            }
        }
    }
    public static void checkChestCollision(){
        if(!HelloController.weapon_Chest.getOpened()) {
            if (HelloController.Will.getImg().getBoundsInParent().intersects(HelloController.weapon_Chest.getImg().getBoundsInParent())) {
                HelloController.equipWeapon();
                HelloController.weapon_Chest.setOpened(true);
            }
        }

    }
    public static void checkWillFall(){
        while (HelloController.Will.isAlive) {
            if (HelloController.Will.getImg().getTranslateY() > -3) {
                Boolean willOnIsland = false;
                for (Island island : HelloController.islandArray) {
                    ImageView will = HelloController.Will.getImg();
                    if (will.getLayoutX() + will.getFitWidth() - 13>= island.getImg().getLayoutX() + island.getImg().getTranslateX() && will.getLayoutX()  <= (island.getImg().getLayoutX() + island.getImg().getTranslateX() + island.getImg().getFitWidth())) {
                        willOnIsland = true;
                        break;
                    }
                }
                if (!willOnIsland) {;
                    gameOver();
                }
            }
        }
    }
    public static void checkOrcFall(){
        while(true) {
            String fallingOrc = null;

            for (Orc orc : HelloController.orcArrayList) {
                Boolean orcOnIsland = false;
                if (orc.getImg().getTranslateY() > -5) {
                    for (Island island : HelloController.islandArray) {
                        ImageView orcImg = orc.getImg();
                        if (orcImg.getLayoutX() + orcImg.getFitWidth() + orcImg.getTranslateX() - 23 >= island.getImg().getLayoutX() + island.getImg().getTranslateX() && orcImg.getLayoutX() + orcImg.getTranslateX() + 26 <= (island.getImg().getLayoutX() + island.getImg().getFitWidth() + island.getImg().getTranslateX())) {
                            orcOnIsland = true;
                            break;
                        }
                    }
                    if (!orcOnIsland) {
                        //System.out.println(orc.getType());
                        orcFall(orc);
                    }
                }
            }
        }
    }
    public static TranslateTransition runTranslateTransitionElements(gameElements node, double x, double y, double duration , boolean infinite , boolean reverse) {
        if (node == null)
            return null;

        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        ImageView n = node.getImg();
        load.setNode(n);
        if(infinite){
            load.setCycleCount(TranslateTransition.INDEFINITE);
        }
        if(reverse){
            load.setAutoReverse(true);
        }
        load.setDuration(Duration.millis(duration));
        load.play();

        if (node instanceof Island || node instanceof Tree || node instanceof Coin || node instanceof GreenOrc || node instanceof redOrc) {
            load.setOnFinished(event -> {
                if (n.getTranslateX() + n.getFitWidth() < 0) {
                    int translateBy = (int) n.getTranslateX() + 90 * 16;
                    n.setTranslateX(translateBy);
                    int r = 20;
                    int rand = (int) ((Math.random() - 0.5) * 2 * r);
                    if(!(node instanceof Island)){
                        rand = -6;
                    }
                    if(node instanceof Coin){
                        node.setVisible(true);
                        node.setOpacity(10);
                    }
                    if(node instanceof WeaponChest){
                        Image img = new Image("file:src/main/resources/com/example/demo1/ChestClosed.png");
                        node.getImg().setImage(img);
                    }
                    n.setLayoutX(rand);
                    n.setTranslateX(translateBy + rand);
                }
            });
        }
        return load;
    }
    public static void  willHasDied(int duration) {
        if (HelloController.Will.isAlive) {
            HelloController.Will.setAlive(false);
            Timeline temp = null;
            //System.out.println("hi");
            for(TranslateTransition bobbing : HelloController.bobbing){
                bobbing.stop();
                temp = new Timeline(new KeyFrame(Duration.millis(duration), ae -> {HelloController.Will.getImg().setTranslateY(0);
                    for(Orc orc : HelloController.orcArrayList){
                        orc.getImg().setTranslateY(0);
                    }
                    bobbing.play();}));
                temp.play();
            }
            temp.setOnFinished(actionEvent -> {ParallelTransition t = Animations.rotateAndTranslate(HelloController.Will.getImg(), 0, 300, 2500, false, false);
                Animations.runTranslateTransition(HelloController.respawnMenu.getRespawnMenu(), 0, -550, 1000, false, false);
                t.setOnFinished(actionEvent2 -> {
                    move_Back(-360 , 1);

                });});


        }
    }
    public static void respawnWill(){

    }
    public static void pushOrc(Orc orc){
        if(!deathByOrc) {
            runTranslateTransition(orc.getImg(), 200, 0, 300, false, false);
            deathByOrc=false;
            orcToOrc(orc);

        }
    }
    public static void move_Back(int moveBy , int duration){
        if (!HelloController.pauseMenuUp) {
            for (gameElements element : HelloController.allObjects) {
                if (element instanceof Will)
                    continue;
                Animations.runTranslateTransitionElements(element, moveBy, 0, duration, false, false);
            }
            //System.out.println(HelloController.islandArray[0].getTranslateX() + HelloController.islandArray[0].getLayoutX());
        }
    }
    public static void gameOver() {
        if (HelloController.Will.getAlive()){
            HelloController.Will.setAlive(false);
            Animations.rotateAndTranslate(HelloController.Will.getImg(), 0, 300, 2500, false, false);
            HelloController.gameOverImage.getImg().setOpacity(10);
            ScaleTransition st = new ScaleTransition(Duration.millis(2000), HelloController.gameOverImage.getImg());
            st.setToX(20);
            st.setToY(20);
            st.play();
            //HelloController.back_to_menu();
        }
    }
    public static void willOnOrc(){

    }
    public static void orcFall(Orc orc){

        //orc.getImg().setTranslateY(30);
//        TranslateTransition t = runTranslateTransitionElements(orc , 0 , 300 , 500 , false , false);
//        t.setOnFinished(actionEvent -> {orc.getImg().setTranslateX(90*15);
//                                        orc.getImg().setTranslateY(-330);});
//        for(int i = 0 ; i<140 ; i++){
//            orc.getImg().setTranslateY(orc.getImg().getTranslateY() + 1);
//        }
        orc.getImg().setTranslateX(90*15);
        //orc.getImg().setTranslateY(-30);
//        for(int i = 0 ; i<300 ; i++){
//            orc.getImg().setTranslateY(orc.getImg().getTranslateY() -1);
//        }

        //TranslateTransition t = runTranslateTransition(orc.getImg() , 100 , 0 , 1 , false , false);
//        t.setOnFinished(event -> {orc.getImg().setTranslateX(90*15);});
    }
    public static void respawnOrc(){

    }

    public static ScaleTransition scaleTransition(ImageView n , int duration , int setToX , int setToY){
        ScaleTransition st = new ScaleTransition(Duration.millis(duration) , n);
        st.setToX(setToX);
        st.setToY(setToY);
        st.play();
        return st;
    }

    public static void orcToOrc(Orc orc){
        for(Orc object : HelloController.orcArrayList){
            if(!object.getType().equals(orc.getType())){
                if(object.getImg().getBoundsInParent().intersects(orc.getImg().getBoundsInParent())){
                    runTranslateTransition(object.getImg(), 250, 0, 300, false, false);
                }
            }
        }
    }

}
