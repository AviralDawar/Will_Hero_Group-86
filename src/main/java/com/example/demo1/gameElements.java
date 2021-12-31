package com.example.demo1;

import javafx.scene.image.ImageView;

public abstract class gameElements extends ImageView {
    //protected int[] position;
    protected int X_speed;
    protected int Y_speed;
    protected ImageView img;
    protected Boolean isAlive = true;
    gameElements(ImageView img){
        this.img = img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public ImageView getImg() {
        return img;
    }

    public int getX_speed() {
        return X_speed;
    }

//    //public int[] getPosition() {
//        return position;
//    }

    public int getY_speed() {
        return Y_speed;
    }

//    public void setPosition(int[] position) {
//        this.position = position;
//    }

    public void setX_speed(int x_speed) {
        X_speed = x_speed;
    }

    public void setY_speed(int y_speed) {
        Y_speed = y_speed;
    }
    public void collide(){

    }

    public void setAlive(Boolean alive) {
        this.isAlive = alive;
    }

    public Boolean getAlive() {
        return isAlive;
    }
}
