package com.example.demo1;

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

public class MainMenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
//    private HelloController hello = new HelloController();


    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView island;

    @FXML
    private ImageView loadGameButton;

    @FXML
    private Label mainMenuLabel;

    @FXML
    private ImageView newGameButton;

    @FXML
    private ImageView will;

    @FXML
    private Group helpDesc;

    @FXML
    private ImageView backButton;

    @FXML
    void loadGame(MouseEvent event) {

    }

    @FXML
    void newGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        HelloController.pauseMenuUp = false;
        HelloController.gameStarted = false;
        HelloController.counter = 0;
        scene = new Scene(root ,915 , 437);
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if (keyEvent.getCode().equals(KeyCode.SPACE)){
//
//                }
//            }
//        });
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onExit(MouseEvent event) {
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }
    private static Boolean helpUP = false;
    @FXML
    void onHelp(MouseEvent event) {
        //runTranslateTransition(helpDesc, 0, -300, 1);
        if(helpUP == false) {
            runTranslateTransition(helpDesc, 0, -300, 1000);
            helpUP = true;
        }
        else{
            runTranslateTransition(helpDesc , 0 , 300 , 1000);
            helpUP = false;
        }

    }

    @FXML
    void back(MouseEvent event){
        runTranslateTransition(helpDesc , 0 , 300 , 1000);
        helpUP = false;
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
    public void runTranslateTransition(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        load.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(will);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setDuration(Duration.millis(700));
        translate.setByY(-50);
        translate.setAutoReverse(true);
        translate.play();
    }
}
