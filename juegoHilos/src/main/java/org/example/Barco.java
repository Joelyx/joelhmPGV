package org.example;

public class Barco {
    private int x;
    private int y;
    boolean hundido=false;
    public Barco(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean getHundido(){
        return this.hundido;
    }
    public void setHundido(){
        this.hundido=true;
    }
}
