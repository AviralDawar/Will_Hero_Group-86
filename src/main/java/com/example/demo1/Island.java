package com.example.demo1;

import javafx.scene.image.ImageView;

public class Island extends gameElements{
    private int length;
    Island(int length , int[] position , ImageView img){
        super(img);
        this.length = length;
        this.position = position;


    }

    public int getLength() {
        return length;
    }
    @Override
    public void collide(){

    }
    public void setImg(ImageView img) {
        this.img = img;
    }
}