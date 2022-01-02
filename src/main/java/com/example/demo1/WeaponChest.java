package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URI;
import java.net.URISyntaxException;

public class WeaponChest extends gameElements{
    private boolean opened = false;
    private ImageView hammerImg;
    private ImageView swordImg;
    private Sword sword;
    private Hammer hammer;
    Image jpg;

    public WeaponChest(ImageView weaponChest) {
        super(weaponChest);
        jpg = new Image("file:src/main/resources/com/example/demo1/WeaponAxe.png");
        hammerImg = new ImageView(jpg);
        hammer = new Hammer(hammerImg,"hammer" ,100 , jpg);
        jpg = new Image("file:src/main/resources/com/example/demo1/WeaponSword.png");
        swordImg = new ImageView(jpg);
        sword = new Sword(swordImg,"sword" , 100 , jpg);
    }


    public Weapon getWeapon() {
        if(generateWeapon() == 1){
            hammer.setPower(100);
            return hammer;
        }
        else{
            sword.setPower(100);
            return sword;
        }

    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    public int generateWeapon(){
        int max = 2;
        int min = 1;
        int b = (int)(Math.random()*(max-min+1)+min);
        return b;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
    public Boolean getOpened(){
        return this.opened;
    }
}
