package com.example.demo1;

import javafx.scene.image.ImageView;

public class Tree extends gameElements{
    Tree(int[] position , ImageView img){
        super(img);
        this.position = position;
    }
    @Override
    public void collide(){

    }
    public void setImg(ImageView img) {
        this.img = img;
    }
    @Override
    public ImageView getImg() {
        return super.getImg();
    }
}
