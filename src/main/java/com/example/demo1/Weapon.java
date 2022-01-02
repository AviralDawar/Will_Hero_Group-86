package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Weapon extends gameElements {
    private int power;
    private String name;
    private Image jpg;

    Weapon(ImageView img ,String type, int power , Image jpg){
        super(img);
        this.name = type;
        this.power = power;
        this.jpg = jpg;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public ImageView getImg() {
        return super.getImg();
    }

    public Image getJpg() {
        return jpg;
    }
}
