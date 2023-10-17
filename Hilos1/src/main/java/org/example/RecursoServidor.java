package org.example;

public class RecursoServidor {
    private int cuenta;

    public RecursoServidor(){
        this.cuenta = 0;
    }

    synchronized public void incrementarCuenta(){
        System.out.println(Thread.currentThread().getName()+" ---> Entra al servidor");

        this.cuenta++;

        System.out.println("Accesos totales: "+ getCuenta());

    }

    public int getCuenta() {
        return cuenta;
    }

}
