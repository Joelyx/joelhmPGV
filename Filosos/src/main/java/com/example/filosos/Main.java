package com.example.filosos;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Filosofo[] filosofos = new Filosofo[5];
        Semaphore[] palillos = new Semaphore[5];

        for (int i = 0; i < 5; i++) {
            palillos[i] = new Semaphore(1);
        }

        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % 5]);
            new Thread(filosofos[i]).start();
        }
    }

}
