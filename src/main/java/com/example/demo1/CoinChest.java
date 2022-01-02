package com.example.demo1;

import javafx.scene.image.ImageView;

public class CoinChest extends gameElements{
    private ImageView img;
    private int coins;
    CoinChest(ImageView img){
        super(img);
        this.coins = 3;//how much coins in 1 chest?
    }

    public ImageView getImg() {
        return img;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
}
