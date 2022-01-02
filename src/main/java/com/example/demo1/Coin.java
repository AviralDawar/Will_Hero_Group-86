package com.example.demo1;

import javafx.scene.image.ImageView;

public class Coin extends gameElements{
    public int[] position;
    Boolean thisCoinCollected = false;
    Coin(int[] position , ImageView img){
        super(img);
        this.position = position;
    }
    @Override
    public void collide(){

    }
    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setThisCoinCollected(Boolean thisCoinCollected) {
        this.thisCoinCollected = thisCoinCollected;
    }
}
