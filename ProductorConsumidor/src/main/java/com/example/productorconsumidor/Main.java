package com.example.productorconsumidor;

public class Main {


    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Consumidor(buffer).start();
        new Productor(buffer).start();
    }

}
