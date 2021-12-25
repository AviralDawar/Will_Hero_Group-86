package com.example.demo1;

public class redOrc extends Orc{
    redOrc(int area , String type , Boolean alive ,int x , int y){
        this.area = area;
        this.type = type;
        this.alive = alive;
        this.position =new int[]{x,y};
    }
}
