package com.example.productorconsumidor;

import java.util.ArrayList;

public class Productor extends Thread{
    private Buffer buffer;
    private int contador;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }
    public void createDatos(){
        while(true){
            if(contador <= 15){
                if(buffer.addToBuffer('a')){
                    contador++;
                    System.out.println("Productor: " + contador);
                }

            }else{
                break;
            }
        }
    }


    @Override
    public void run(){
        createDatos();
    }
}
