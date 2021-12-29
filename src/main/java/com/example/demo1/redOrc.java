package com.example.demo1;

import javafx.scene.image.ImageView;

public class redOrc extends Orc{
    public int[] position;
    redOrc(int area , String type , Boolean alive ,int x , int y, ImageView img){
        super(img);
        this.area = area;
        this.type = type;
        this.alive = alive;
        this.position =new int[]{x,y};
    }
    @Override
    public ImageView getImg() {
        return super.getImg();
    }
}
