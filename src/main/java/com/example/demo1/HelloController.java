package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    private Button backButton2;
    @FXML
    private Group helpDesc;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView will;
    @FXML
    Image myImage = new Image(getClass().getResourceAsStream("pauseMenu-removebg-preview.jpg"));



    @FXML
    private Group pauseMenu;

    @FXML
    private ImageView backButton;

    @FXML
    private ImageView loadGameButton;

    @FXML
    private ImageView newGameButton;




    @FXML
    void onHelp(MouseEvent event) {
        if(gameStarted){
            pauseMenuDisplay();
        }
        else{
            helpDisplay();
        }
    }
    void pauseMenuDisplay(){
        //ask if the animations in the background should be playing or not.
        runTranslateTransition(helpDesc , 0, 500,1);
    }
    void helpDisplay(){
        runTranslateTransition(pauseMenu , 0, 500,1);
    }
    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        return load;
    }
    @FXML
    void startGame(MouseEvent event) {
        gameStarted = true;
        transition();
    }
    @FXML
    void newGame(MouseEvent event){

    }
    @FXML
    void loadGame(MouseEvent event){

    }
    @FXML
    void back(MouseEvent event){

    }


    public void transition(){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(10);
        fade.setToValue(0);
        fade.setCycleCount(1);

        //the transition will set to be auto reversed by setting this to true
        fade.setAutoReverse(false);
        fade.setNode(helpButton);
        //playing the transition
        fade.play();
        FadeTransition fade2 = new FadeTransition();
        helpButton.setImage(myImage);
        fade2.setDuration(Duration.millis(1000));
        fade2.setFromValue(0);
        fade2.setToValue(10);
        fade2.setCycleCount(1);

        //the transition will set to be auto reversed by setting this to true
        fade2.setAutoReverse(false);
        fade2.setNode(helpButton);
        //playing the transition
        fade2.play();

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
