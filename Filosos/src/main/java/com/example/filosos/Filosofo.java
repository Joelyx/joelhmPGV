package com.example.filosos;

import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable{
    private final int id;
    private final Semaphore palilloIzq;
    private final Semaphore palilloDer;

    public Filosofo(int id, Semaphore palilloIzq, Semaphore palilloDer) {
        this.id = id;
        this.palilloIzq = palilloIzq;
        this.palilloDer = palilloDer;
    }

    public void run() {
        try {
            while (true) {
                pensar();
                levantarPalillos();
                comer();
                bajarPalillos();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando...");
        Thread.sleep(1000);
    }

    private void levantarPalillos() throws InterruptedException {
        if (id % 2 == 0) {
            palilloIzq.acquire();
            palilloDer.acquire();
        } else {
            palilloDer.acquire();
            palilloIzq.acquire();
        }
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comiendo...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void bajarPalillos() {
        palilloIzq.release();
        palilloDer.release();
    }
}
