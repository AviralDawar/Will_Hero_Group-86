package com.example.demo1;

import javafx.scene.image.ImageView;

public class TNT extends gameElements{
    public int[] position;
    Boolean exploded = false;
    TNT(int[] position , ImageView img){
        super(img);
        this.position = position;
    }
    @Override
    public void collide(){

    }
    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setExploded(Boolean exploded) {
        this.exploded = exploded;
    }

    public Boolean getExploded() {
        return exploded;
    }

    @Override
    public ImageView getImg() {
        return super.getImg();
    }
}
