package com.example.demo1;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
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
    private Group pause_Menu;

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
    private Group respawn_Menu;
    @FXML
    private ImageView greenOrc1;
    @FXML
    private ImageView redOrc1;

    @FXML
    public void pauseMenuDisplay() {
        //ask if the animations in the background should be playing or not.
        //runTranslateTransition(pauseMenu , 0, 500,1);
        if (!pauseMenuUp) {
            Animations.runTranslateTransition(pauseMenu.pauseMenu, 0, -300, 1000, false, false);
            pauseMenuUp = true;
        } else {
            Animations.runTranslateTransition(pauseMenu.pauseMenu, 0, 300, 1000, false, false);
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
        Animations.runTranslateTransition(pauseMenu.pauseMenu, 0, 300, 1000, false, false);
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
    public static Will Will;
    public static PauseMenu pauseMenu;
    public static RespawnMenu respawnMenu;
    public static GreenOrc gOrc1;
    public static redOrc rOrc1;
    public static GreenOrc gOrc2;
    public static redOrc rOrc2;
    public static Orc[] orcArrayList = new Orc[4];
    public static TranslateTransition[] bobbing = new TranslateTransition[3];
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bobbing[0] = Animations.runTranslateTransition(will, 0, -100, 500, true, true);
        bobbing[1] = Animations.runTranslateTransition(redOrc, 0, -95, 1000, true, true);
        bobbing[2] = Animations.runTranslateTransition(greenOrc, 0, -95, 1000, true, true);

        Will = new Will(will);
        pauseMenu = new PauseMenu(pause_Menu);
        respawnMenu = new RespawnMenu(respawn_Menu);

        int[] position = new int[]{0 , 286};
        Island Island1 = new Island(0 , position , island1 , "island1" , 51);

        Island Island2 = new Island(0 , position , island2 , "island2" , 379);

        Island Island3 = new Island(0 , position , island3 , "island3" , 766);

        Island Island4 = new Island(0 , position , island4 , "island4",1082);
        //for trees
        Tree Tree1 = new Tree(position , tree1);
        Tree Tree2 = new Tree(position , tree2);
        Tree Tree3 = new Tree(position , tree3);
        Tree Tree4 = new Tree(position , tree4);
        //for orcs
        gOrc1 = new GreenOrc(0,"green",true,0,0,greenOrc);
        gOrc2 = new GreenOrc(0,"green",true,0,0,greenOrc1);
        rOrc1 = new redOrc(0,"red",true,0,0,redOrc);
        rOrc2 = new redOrc(0,"red",true,0,0,redOrc1);

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
        allObjects.add(gOrc1);
        allObjects.add(rOrc1);
        allObjects.add(Will);

        orcArrayList[0] = gOrc1;
        orcArrayList[1] = gOrc2;
        orcArrayList[2] = rOrc1;
        orcArrayList[3] = rOrc2;


        islandArray[0] = Island1;
        islandArray[1] = Island2;
        islandArray[2] = Island3;
        islandArray[3] = Island4;
        AnimationTimer collisionTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    Animations.checkCollisionOrc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        collisionTimer.start();
        new Thread(() -> Animations.checkWillFall()).start();
        new Thread(() -> Animations.checkOrcFall()).start();
    }
    public static Boolean clickToPlayActivated = true;
    public static int counter = 0;
    public static int position = 0;
    //the move back function is implemented on every click to check for collisions and to re position the islands.
    @FXML
    void moveBack(MouseEvent event) {
        Animations.move_Back(-90 , 125);
        counter += 1;
        score.setText(String.valueOf(counter));
    }
}
