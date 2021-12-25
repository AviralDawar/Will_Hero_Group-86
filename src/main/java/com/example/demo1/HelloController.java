package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Pane root;
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
    private ImageView island4;
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
    @FXML
    public static boolean pauseMenuUp = false;
    @FXML
    private ImageView tree1;
    @FXML
    private ImageView tree2;
    @FXML
    private ImageView tree3;
    @FXML
    private ImageView coin1;


    @FXML
    void pauseMenuDisplay() {
        //ask if the animations in the background should be playing or not.
        //runTranslateTransition(pauseMenu , 0, 500,1);
        if (!pauseMenuUp) {
            Animations.runTranslateTransition(pauseMenu, 0, -300, 1000, false, false);
            pauseMenuUp = true;
        } else {
            Animations.runTranslateTransition(pauseMenu, 0, 300, 1000, false, false);
            pauseMenuUp = false;
        }
    }

    @FXML
    void saveGame() {
    }

    @FXML
    void startGame(MouseEvent event) {
    }

    @FXML
    void newGame(MouseEvent event) {

    }

    @FXML
    void loadGame(MouseEvent event) {

    }

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 690, 335);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void back(MouseEvent event) {
        Animations.runTranslateTransition(pauseMenu, 0, 300, 1000, false, false);
    }

    @FXML
    void removeTapToPlay(MouseEvent event) {
        if (!gameStarted) {
            Animations.transition(TapToPlay, 10, 0, 1000);
            Animations.transition(score, 0, 10, 1000);
        }
        gameStarted = true;
    }

    //    @FXML
//    private final ImageView img = new ImageView();
    public static ArrayList<Node> allObjects = new ArrayList<Node>();
    private static Island[] islandArray = new Island[4];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Animations.runTranslateTransition(will, 0, -70, 500, true, true);
        Animations.runTranslateTransition(redOrc, 0, -70, 500, true, true);
        Animations.runTranslateTransition(greenOrc, 0, -70, 500, true, true);
        allObjects.add(island1);
        allObjects.add(island2);
        allObjects.add(island3);
        allObjects.add(island4);
        allObjects.add(tree1);
        allObjects.add(tree2);
        allObjects.add(tree3);
        allObjects.add(coin1);
        allObjects.add(greenOrc);
        allObjects.add(redOrc);
        allObjects.add(will);

//        System.out.println(island1.getLayoutX());
//        System.out.println(island1.getLayoutY());
//        System.out.println(island2.getLayoutX());
//        System.out.println(island3.getLayoutX());
//        System.out.println(island4.getLayoutX());
        int[] position = new int[]{51 , 286};
        Island Island1 = new Island(0 , position , island1);
        position[0] = 379;
        Island Island2 = new Island(0 , position , island2);
        position[0] =746;
        Island Island3 = new Island(0 , position , island3);
        position[0] = 1135;
        Island Island4 = new Island(0 , position , island4);

        islandArray[0] = Island1;
        islandArray[1] = Island2;
        islandArray[2] = Island3;
        islandArray[3] = Island4;

        AnimationTimer collisionTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                Animations.checkCollisionOrc();
            }
        };

        collisionTimer.start();
    }

    public static int counter = 0;
    public static int position = 0;

    @FXML
    void moveBack(MouseEvent event) {
        if (!pauseMenuUp) {
            for (Node node : allObjects) {
                if (node.getId().equals("will"))
                    continue;
                Animations.runTranslateTransition(node, -90, 0, 125, false, false);
            }
            position = position + 90;

//            if((counter+1)%4 == 0 && counter!=0){
//                island1.setX(640 + position);
//                //island2.setX();
//                System.out.println("visible");
//
//            }
//            if(counter%8 == 0 && counter!=0){
//                island1.setX(2000);
//
//            }


//            System.out.println(island1.getLayoutX());
//            System.out.println(will.getLayoutX());
//            System.out.println(island1.getX());
            counter += 1;
//            System.out.println(counter);
            score.setText(String.valueOf(counter));
        }
    }
}
