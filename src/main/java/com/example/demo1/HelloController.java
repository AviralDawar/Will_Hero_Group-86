package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public static boolean gameStarted;

    static {
        gameStarted = false;
    }
    @FXML
    private Label TapToPlay;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView will;
    @FXML
    private ImageView background;

    @FXML
    private Group pauseMenu;

    @FXML
    private ImageView backButton;

    @FXML
    private ImageView loadGameButton;

    @FXML
    private ImageView newGameButton;

    @FXML
    private ImageView pauseButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView saveButton;
    //    @FXML
//    void onHelp(MouseEvent event) {
//        if(gameStarted){
//            pauseMenuDisplay();
//        }
//        else{
//            helpDisplay();
//        }
//    }
    @FXML
    void pauseMenuDisplay(){
        //ask if the animations in the background should be playing or not.
        //runTranslateTransition(pauseMenu , 0, 500,1);
        transition(pauseMenu , 0 , 10 , 1000);

    }
    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        return load;
    }
    public void transition(Node node , int from , int to , int duration){
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
    @FXML
    void saveGame(){

    }
    @FXML
    void startGame(MouseEvent event) {
        if(!gameStarted) {
            transition(TapToPlay, 10, 0, 1000);
        }
        gameStarted = true;

    }
    @FXML
    void newGame(MouseEvent event){

    }
    @FXML
    void loadGame(MouseEvent event){

    }
    @FXML
    void back(MouseEvent event){
        transition(pauseMenu , 10 , 0 , 1 );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(will);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setDuration(Duration.millis(700));
        translate.setByY(-70);
        translate.setAutoReverse(true);
        translate.play();
    }

}

