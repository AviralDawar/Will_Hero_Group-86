package com.example.demo1;

import javafx.scene.image.ImageView;

public class Island extends gameElements{
    private int length;
    private final String name;
    Island(int length , int[] position , ImageView img , String name){
        super(img);
        this.length = length;
        this.position = position;
        this.name = name;


    }

    public String getName() {
        return this.name;
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
