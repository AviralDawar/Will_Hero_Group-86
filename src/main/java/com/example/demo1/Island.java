package com.example.demo1;

import javafx.scene.image.ImageView;

public class Island extends gameElements{
    private int length;
    private final String name;
    public int[] position;
    private int x;
    Island(int length , int[] position , ImageView img , String name,int x){
        super(img);
        this.length = length;
        this.position = position;
        this.name = name;
        this.x = x;


    }
    public int get_X(){
        return this.x;
    }
    public void set_X(int x){
        this.x = x;
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
