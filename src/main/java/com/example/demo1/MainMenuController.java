package com.example.demo1;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    Stage stage;
    private Scene scene;
    private Parent root;

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
    void newGame(MouseEvent event) {

    }

    @FXML
    void onExit(MouseEvent event) {
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onHelp(MouseEvent event) {
        transition(helpDesc , 0 , 10 , 1000);
    }

    @FXML
    void back(MouseEvent event){
        transition(helpDesc , 10 , 0 , 1);
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
