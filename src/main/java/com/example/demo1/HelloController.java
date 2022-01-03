package com.example.demo1;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Stage stage;
    public Scene scene;
    public Pane root;
    public static boolean gameStarted;

    static {
        gameStarted = false;
    }
    @FXML
    private Label resurrectLabel;
    @FXML
    private ImageView weaponChest;
    @FXML
    private ImageView coinChest;
    @FXML
    private ImageView homeButton1;
    @FXML
    private Label coinsCollected;
    @FXML
    private Label score;

    @FXML
    private Label resurrect;

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
    private ImageView island5;


    @FXML
    private Label TapToPlay;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView will;
    @FXML
    private ImageView background;
    @FXML
    private ImageView gameOverImg;
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
    private ImageView c4;
    @FXML
    private ImageView c5;

    @FXML
    private ImageView tree4;
    @FXML
    private ImageView tree5;
    @FXML
    private ImageView tree6;
    @FXML
    private ImageView TNT;


    @FXML
    private Group respawn_Menu;
    @FXML
    private ImageView greenOrc1;
    @FXML
    private ImageView redOrc1;
    @FXML
    private ImageView bigCoin;

    @FXML
    private ImageView wpn;
    @FXML
    private ImageView hammerButton;
    @FXML
    private Rectangle swordButton;
    @FXML
    private ImageView bossOrc;
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
        for (gameElements object : allObjects) {
            String filename = object.toString();
            ProgressManager.serialize(object, filename);
        }
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
    public static TranslateTransition[] bobbing = new TranslateTransition[6];
    public static GameOver gameOverImage;
    public static Coin[] coinList = new Coin[5];
    public static CoinsLabel coins_collected;
    public static WeaponChest weapon_Chest;
    public static CoinChest coin_Chest;
    private static Coin big_coin;
    public static Weapon weapon;
    public static TNT tnt;
    public static Orc boss_orc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bobbing[0] = Animations.runTranslateTransition(will, 0, -100, 500, true, true);
        bobbing[1] = Animations.runTranslateTransition(redOrc, 0, -95, 1000, true, true);
        bobbing[2] = Animations.runTranslateTransition(greenOrc, 0, -95, 1000, true, true);
        bobbing[3] = Animations.runTranslateTransition(redOrc1, 0, -95, 1000, true, true);
        bobbing[4] = Animations.runTranslateTransition(greenOrc1, 0, -95, 1000, true, true);
        bobbing[5] = Animations.runTranslateTransition(wpn, 0 , -100 , 500 , true , true);


        gameOverImage = new GameOver(gameOverImg);
        Will = new Will(will);
        pauseMenu = new PauseMenu(pause_Menu);
        respawnMenu = new RespawnMenu(respawn_Menu);
        coins_collected = new CoinsLabel(coinsCollected);
        weapon_Chest = new WeaponChest(weaponChest);
        coin_Chest = new CoinChest(coinChest);
        weapon = new Weapon(wpn , null , 0 , null);


        int[] position = new int[]{0 , 286};
        Island Island1 = new Island(0 , position , island1 , "island1" , 51);
        Island Island2 = new Island(0 , position , island2 , "island2" , 379);
        Island Island3 = new Island(0 , position , island3 , "island3" , 766);
        Island Island4 = new Island(0 , position , island4 , "island4",1082);

        tnt = new TNT(position , TNT);

        //for trees
        Tree Tree1 = new Tree(position , tree1);
        Tree Tree2 = new Tree(position , tree2);
        Tree Tree3 = new Tree(position , tree3);
        Tree Tree4 = new Tree(position , tree4);
        Tree Tree5 = new Tree(position , tree5);
        //Tree Tree6 = new Tree(position , tree6);


        //for orcs
        gOrc1 = new GreenOrc(0,"green1",true,0,0,greenOrc);
        gOrc2 = new GreenOrc(0,"green2",true,0,0,greenOrc1);
        rOrc1 = new redOrc(0,"red1",true,0,0,redOrc);
        rOrc2 = new redOrc(0,"red2",true,0,0,redOrc1);
        boss_orc = new GreenOrc(0 , "boss" , true ,0 , 0 , bossOrc);

        //for coins
        Coin coin1 = new Coin(position , c1);
        Coin coin2 = new Coin(position , c2);
        Coin coin3 = new Coin(position , c3);
        Coin coin4 = new Coin(position , c4);
        Coin coin5 = new Coin(position , c5);
        big_coin = new Coin(position ,bigCoin);

        coinList[0] =coin1;
        coinList[1] =coin2;
        coinList[2] =coin3;
        coinList[3] =coin4;
        coinList[4] =coin5;

        allObjects.add(tnt);
        allObjects.add(Island1);
        allObjects.add(Island2);
        allObjects.add(Island3);
        allObjects.add(Island4);

        allObjects.add(Tree1);
        allObjects.add(Tree2);
        allObjects.add(Tree3);
        allObjects.add(Tree4);
        allObjects.add(Tree5);

        allObjects.add(coin1);
        allObjects.add(coin2);
        allObjects.add(coin3);
        allObjects.add(coin4);
        allObjects.add(coin5);

        allObjects.add(gOrc1);
        allObjects.add(rOrc1);
        allObjects.add(gOrc2);
        allObjects.add(rOrc2);
        allObjects.add(Will);

        allObjects.add(coin_Chest);
        allObjects.add(weapon_Chest);
        allObjects.add(boss_orc);

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
                    Animations.checkCoinCollision();
                    Animations.checkChestCollision();
                    //Animations.checkBossFall();
                    Animations.checkBossCollision();
                    //Animations.orcToOrc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        collisionTimer.start();
        new Thread(() -> Animations.checkWillFall()).start();
        new Thread(() -> Animations.checkOrcFall()).start();
        new Thread(()->Animations.checkBossFall());
    }
    public static Boolean clickToPlayActivated = true;
    public static int counter = 0;
    public static int position = 0;
    //the move back function is implemented on every click to check for collisions and to re position the islands.
    @FXML
    void moveBack(MouseEvent event) {
        if(clickToPlayActivated) {
            Animations.move_Back(-90, 125);
            if(Will.getHasWeapon()){
                if(Will.getWeapon().getPower() != 0) {
                    Will.getWeapon().setPower(Will.getWeapon().getPower() - 10);
                }
                else{
                    Image img = new Image("file:src/main/resources/com/example/demo1/WeaponBrokenSword.png");
                    //System.out.println("entered else");
                    Will.getWeapon().getImg().setImage(img);
                    Will.removeFromList(Will.getWeapon());
                }
            }

            counter += 1;
            score.setText(String.valueOf(counter));
            int x = 0;
            int y = 0;
            if(counter == 25|| counter == 50 || counter == 75){

                for(Island island : islandArray){
                    if(island.getImg().getTranslateX()>800){
                        x = (int) (island.getImg().getTranslateX() + island.getImg().getFitWidth()/2);
                        y = 252;
                        //System.out.println("entered if" +island);
                        break;
                    }
                }
                //System.out.println("TNT TRYING");
                tnt.getImg().setLayoutY(y);
                tnt.getImg().setLayoutX(x);
            }
            if(counter == 107){
                for(Island island : islandArray){
                    if(island.getImg().getTranslateX()>800){
                        x = (int) (island.getImg().getTranslateX() + island.getImg().getFitWidth()/2);
                        y = 212;
                        //System.out.println("entered if" +island);

                        break;
                    }
                }
                System.out.println(x);
                System.out.println(y);
                boss_orc.getImg().setTranslateX(x);
                boss_orc.getImg().setTranslateY(y);
                Animations.runTranslateTransition(bossOrc , 0 , -30 , 1000 , true , true);
            }
            if(counter == 115){
                Animations.gameOver();
            }
        }
    }

    public static Boolean clickToPlayActivate = true;
    @FXML
    void resurrect(){
        if(Will.getCurrentCoins()>=10) {
            Will.setAlive(true);
            clickToPlayActivated = true;
            Animations.runTranslateTransition(
                    respawnMenu.getRespawnMenu(), 0, 550, 100, false, false);
        }
        else{
            resurrectLabel.setText("CAN'T RESURRECT WITH <=10 COINS , PRESS THE HOME BUTTON TO GO TO THE MAIN MENU");
        }


    }
    public static int coinCounter = 0;
    static void updateCoins(Coin coin){
        if(!coin.thisCoinCollected) {
            coin.setThisCoinCollected(true);
            coinCounter++;
            coin.getImg().setOpacity(0);
            int r = 4;
            int rand = (int) ((Math.random() - 0.5) * 2 * r);
            //coin.getImg().setTranslateY(rand);
            coins_collected.getCoinsCollected().setText(String.valueOf(coinCounter));
            Will.setCurrentCoins(Will.getCurrentCoins() + 1);
            //System.out.println(Will.getCurrentCoins());
            ScaleTransition st = Animations.scaleTransition(big_coin.getImg() , 500 , 2 , 2);
            st.setOnFinished(actionEvent -> {Animations.scaleTransition(big_coin.getImg() , 500 , -2 , -2);});
        }
    }
    static void coinsFromChestOrc(){
        coinCounter +=3;
        coins_collected.getCoinsCollected().setText(String.valueOf(coinCounter));
        Will.setCurrentCoins(Will.getCurrentCoins() + 3);
//        ScaleTransition st = Animations.scaleTransition(big_coin.getImg() , 500 , 1 , 1);
//        st.setOnFinished(actionEvent -> {Animations.scaleTransition(big_coin.getImg() , 500 , -1 , -1);});

    }
    static void equipWeapon(){

        Weapon chestWeapon = weapon_Chest.getWeapon();
        if(chestWeapon.getName().equals("hammer")){
            weapon.getImg().setImage(chestWeapon.getJpg());
            weapon.getImg().toFront();
            weapon.getImg().setOpacity(10);

            //System.out.println("bruh");
        }
        else{
            weapon.setImage(chestWeapon.getImage());
            weapon.getImg().setImage(chestWeapon.getJpg());
            weapon.getImg().toFront();
            weapon.getImg().setOpacity(10);
            //System.out.println("bruh2");
        }
        Image openedChest = new Image("file:src/main/resources/com/example/demo1/ChestOpen.png");
        weapon_Chest.getImg().setImage(openedChest);
        if(Will.getWeaponArrayList().size() !=0){
            if(!(Will.getWeaponArrayList().get(0).getName().equals(chestWeapon.getName()))){
                Will.addToList(chestWeapon);
            }
        }
        Will.setWeapon(chestWeapon);
        Will.setHasWeapon(true);

    }
}
