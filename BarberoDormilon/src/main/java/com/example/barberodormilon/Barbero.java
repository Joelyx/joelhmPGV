package com.example.barberodormilon;
public class Barbero extends Thread {
    private Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            barberia.atenderCliente();
        }
    }
}
