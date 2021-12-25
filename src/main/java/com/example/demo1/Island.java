package com.example.demo1;

import javafx.scene.image.ImageView;

public class Island extends gameElements{
    private int length;
    public ImageView islandName;
    Island(int length , int[] position , ImageView islandName){
        this.length = length;
        this.position = position;
        this.islandName = islandName;
    }

    public int getLength() {
        return length;
    }
    @Override
    public void collide(){

    }

}
