package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static boolean gameStarted;

    static {
        gameStarted = false;
    }
    @FXML
    private Label score;
    @FXML
    private ImageView redOrc;
    @FXML
    private ImageView greenOrc;
    @FXML
    private ImageView clickHereToMove;
    @FXML
    private ImageView island1;
    @FXML
    private ImageView island2;
    @FXML
    private ImageView island3;
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
    private static boolean pauseMenuUp=false;
    @FXML
    void pauseMenuDisplay(){
        //ask if the animations in the background should be playing or not.
        //runTranslateTransition(pauseMenu , 0, 500,1);
        if(!pauseMenuUp) {
            runTranslateTransition(pauseMenu, 0, -300, 1000 , false , false);
            pauseMenuUp = true;
        }
        else{
            runTranslateTransition(pauseMenu, 0, 300, 1000 , false , false);
            pauseMenuUp = false;
        }
    }
    public static void runTranslateTransition(Node n, double x, double y, double duration , boolean infinite , boolean reverse) {
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


    }
    @FXML
    void newGame(MouseEvent event){

    }
    @FXML
    void loadGame(MouseEvent event){

    }
    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root , 690 ,335);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void back(MouseEvent event){
        runTranslateTransition(pauseMenu, 0, 300, 1000 , false , false);
    }
    @FXML
    void removeTapToPlay(MouseEvent event){
        if(!gameStarted) {
            transition(TapToPlay, 10, 0, 1000);
        }
        gameStarted = true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        runTranslateTransition(will , 0 , -70 , 500 , true , true);
        runTranslateTransition(redOrc , 0 , -70 , 500 , true , true);
        runTranslateTransition(greenOrc , 0 , -70 , 500 , true , true);



    }
    public static int counter = 0;
    @FXML
    void moveWill(MouseEvent event){
        runTranslateTransition(will , 80 , 0 , 125  ,false , false);
        counter++;
        score.setText(String.valueOf(counter));
    }

}

