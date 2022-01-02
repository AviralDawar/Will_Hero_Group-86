package com.example.demo1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hammer extends Weapon{
    Hammer(ImageView img , String type , int power , Image jpg){
        super(img , type , power , jpg);
    }

    @Override
    public ImageView getImg() {
        return super.getImg();
    }
}
