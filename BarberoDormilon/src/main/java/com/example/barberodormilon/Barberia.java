package com.example.barberodormilon;

import java.util.concurrent.Semaphore;

public class Barberia {
    private Semaphore sillaDisponible;
    private Semaphore clienteEsperando;
    private Semaphore barberoDurmiendo;

    public Barberia(int numSillas) {
        sillaDisponible = new Semaphore(numSillas);
        clienteEsperando = new Semaphore(0);
        barberoDurmiendo = new Semaphore(0);
    }

    public void solicitarCorte(String nombreCliente) {
        try {
            System.out.println(nombreCliente + " llega a la barbería.");
            if (sillaDisponible.tryAcquire()) {
                System.out.println(nombreCliente + " se sienta en la silla de espera.");
                clienteEsperando.release();
                barberoDurmiendo.acquire();
                System.out.println(nombreCliente + " está recibiendo un corte de pelo.");
                sillaDisponible.release();
            } else {
                System.out.println("La sala de espera está llena. " + nombreCliente + " se va.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void atenderCliente() {
        try {
            System.out.println("El barbero está esperando a un cliente.");
            if (clienteEsperando.tryAcquire()) {
                System.out.println("El barbero está cortando el pelo.");
                Thread.sleep(2000); // Simula el tiempo que lleva cortar el pelo
                System.out.println("Corte de pelo terminado.");
                barberoDurmiendo.release();
            } else {
                System.out.println("No hay clientes en la sala de espera. El barbero se duerme.");
                barberoDurmiendo.release();
                Thread.sleep(2000); // Simula que el barbero duerme un rato
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

