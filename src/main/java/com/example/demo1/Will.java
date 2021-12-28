package com.example.demo1;

import javafx.scene.image.ImageView;

public class Will extends gameElements{
    private int currentCoins;
    private int currentScore;
    private Boolean hasResurrected;
    private Boolean isAlive;
    private Boolean hasWeapon;

    public Will(ImageView img){
        super(img);
        this.currentCoins = 0;
        this.currentScore = 0;
        this.hasResurrected = false;
        this.isAlive = true;
        this.hasWeapon = false;

    }



    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    @Override
    public void setPosition(int[] position) {
        super.setPosition(position);
    }

    @Override
    public void setX_speed(int x_speed) {
        super.setX_speed(x_speed);
    }

    @Override
    public void setY_speed(int y_speed) {
        super.setY_speed(y_speed);
    }

    public void setCurrentCoins(int currentCoins) {
        this.currentCoins = currentCoins;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setHasResurrected(Boolean hasResurrected) {
        this.hasResurrected = hasResurrected;
    }

    public void setHasWeapon(Boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    @Override
    public int[] getPosition() {
        return super.getPosition();
    }

    public Boolean getHasResurrected() {
        return hasResurrected;
    }

    public Boolean getHasWeapon() {
        return hasWeapon;
    }

    @Override
    public ImageView getImg() {
        return super.getImg();
    }

    public int getCurrentCoins() {
        return currentCoins;
    }

    public int getCurrentScore() {
        return currentScore;
    }
}
