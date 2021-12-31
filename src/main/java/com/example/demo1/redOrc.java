package com.example.demo1;

import javafx.scene.image.ImageView;

public class redOrc extends Orc{
    public int[] position;
    redOrc(int area , String type , Boolean alive ,int x , int y, ImageView img){
        super(img);
        this.area = area;
        this.type = type;
        this.isAlive = alive;
        this.position =new int[]{x,y};
    }
    @Override
    public ImageView getImg() {
        return super.getImg();
    }

    @Override
    public Boolean getAlive() {
        return super.getAlive();
    }

    @Override
    public void setAlive(Boolean alive) {
        super.setAlive(alive);
    }
}
