package com.example.demo1;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
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
    private ImageView c1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView tree4;



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

    public static ArrayList<gameElements> allObjects = new ArrayList<gameElements>();
    public static Island[] islandArray = new Island[4];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Animations.runTranslateTransition(will, 0, -70, 500, true, true);
        Animations.runTranslateTransition(redOrc, 0, -70, 500, true, true);
        Animations.runTranslateTransition(greenOrc, 0, -70, 500, true, true);
        Will Will = new Will(will);

        int[] position = new int[]{51 , 286};
        Island Island1 = new Island(0 , position , island1);
        position[0] = 379;
        Island Island2 = new Island(0 , position , island2);
        position[0] =746;
        Island Island3 = new Island(0 , position , island3);
        position[0] = 1135;
        Island Island4 = new Island(0 , position , island4);
        position[0] = 0;
        position[1] = 0;
        //for trees
        Tree Tree1 = new Tree(position , tree1);
        Tree Tree2 = new Tree(position , tree2);
        Tree Tree3 = new Tree(position , tree3);
        Tree Tree4 = new Tree(position , tree4);
        //for orcs
        GreenOrc gOrc = new GreenOrc(0,"green",true,0,0,greenOrc);
        GreenOrc rOrc = new GreenOrc(0,"red",true,0,0,redOrc);
        //for coins
        Coin coin1 = new Coin(position , c1);
        Coin coin2 = new Coin(position , c2);
        Coin coin3 = new Coin(position , c3);

        allObjects.add(Island1);
        allObjects.add(Island2);
        allObjects.add(Island3);
        allObjects.add(Island4);
        allObjects.add(Tree1);
        allObjects.add(Tree2);
        allObjects.add(Tree3);
        allObjects.add(Tree4);
        allObjects.add(coin1);
        allObjects.add(coin2);
        allObjects.add(coin3);
        allObjects.add(gOrc);
        allObjects.add(rOrc);
        allObjects.add(Will);

        islandArray[0] = Island1;
        islandArray[1] = Island2;
        islandArray[2] = Island3;
        islandArray[3] = Island4;

        AnimationTimer collisionTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                Animations.checkCollisionOrc();
                Animations.checkWillFall();
            }
        };

        collisionTimer.start();
    }

    public static int counter = 0;
    public static int position = 0;
    //the move back function is implemented on every click to check for collisions and to re position the islands.
    @FXML
    void moveBack(MouseEvent event) {
        if (!pauseMenuUp) {

            for (gameElements element : allObjects) {
                if (element instanceof Will)
                    continue;
                Animations.runTranslateTransitionElements(element, -90, 0, 125, false, false);

            }
            position = position + 90;
            counter += 1;
            score.setText(String.valueOf(counter));
        }
    }
}
