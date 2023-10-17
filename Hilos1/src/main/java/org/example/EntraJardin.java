package org.example;

public class EntraJardin extends Thread{
    private RecursoServidor recursoServidor;

    public EntraJardin(String nombre, RecursoServidor recursoServidor){
        this.recursoServidor = recursoServidor;
        this.setName(nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (recursoServidor){
                recursoServidor.incrementarCuenta();
            }
        }
    }
}
