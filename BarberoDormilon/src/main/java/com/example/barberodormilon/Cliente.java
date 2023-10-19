package com.example.barberodormilon;
public class Cliente extends Thread {
    private Barberia barberia;
    private String nombre;

    public Cliente(Barberia barberia, String nombre) {
        this.barberia = barberia;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        barberia.solicitarCorte(nombre);
    }
}
