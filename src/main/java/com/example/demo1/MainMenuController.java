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
import javafx.scene.layout.Pane;
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
        Pane root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        HelloController.pauseMenuUp = false;
        HelloController.gameStarted = false;
        HelloController.counter = 0;

//        HelloController.addIsland(root);
        scene = new Scene(root ,915 , 437);
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
            Animations.runTranslateTransition(helpDesc, 0, -300, 1000,false,false);
            helpUP = true;
        }
        else{
            Animations.runTranslateTransition(helpDesc , 0 , 300 , 1000,false,false);
            helpUP = false;
        }
    }
    @FXML
    void back(MouseEvent event){
        Animations.runTranslateTransition(helpDesc , 0 , 300 , 1000,false,false);
        helpUP = false;
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
