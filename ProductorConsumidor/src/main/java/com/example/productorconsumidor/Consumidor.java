package com.example.productorconsumidor;

public class Consumidor extends Thread{
    public Buffer buffer;
    public int contador;

    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }

    public void readDatos(){
        while(true){
            if(contador <= 15){
                if(buffer.removeFromBuffer()){
                    contador++;
                    System.out.println("Consumidor: " + contador);
                }

            }else{
                break;
            }
        }
    }

    @Override
    public void run(){
        readDatos();
    }
}
