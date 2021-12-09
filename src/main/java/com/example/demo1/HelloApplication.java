package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 915, 437);
        stage.setTitle("WillTheHero");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //ksksjhdsk


        /*
        ->FOR RESIZING AND SETTING HEIGHT WIDTH-
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setResizable(false); ->if we don't want to resize the stage.

        ->FOR SETTING THE POSITION OF THE STAGE ON THE SCREEN
        stage.setX();
        stage.setY();

        ->FOR SETTING FULL SCREEN AND EXIT SCREEN MESSAGES
        stage.setFullScreen(true);
        stage.setFullScreenHint("press q to exit the game");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        ->FOR ADDING AN ICON
        Image icon = new Image("icon.png"); here the icon should be in the same folder.
        stage.setIcons().add(icon);

         ->FOR PLACING TEXT IN THE SCENE
         Text text = new Text();
         text.setText("text here");
         text.setX(50);
         text.setY(50);
         text.setFont(Font.font("Verdana",50));
         text.setFill(Color.LIMEGREEN);
         root.getChildren().add(text);


         */
    }

    public static void main(String[] args) {
        launch();
    }
}