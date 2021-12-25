package com.example.demo1;

public abstract class Orc extends gameElements {
    protected int area;
    protected String type;
    protected Boolean alive;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Boolean getAlive() {
        return alive;
    }

    public int getArea() {
        return area;
    }
    @Override
    public void collide(){

    }

}
