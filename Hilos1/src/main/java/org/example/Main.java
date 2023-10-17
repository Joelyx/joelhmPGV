package org.example;

// necesitamos el codigo de empleado y hora de fichaje
// lo que tiene que hacer el hilo, es comparar la hora del fichaje vs la hora de entrada real
public class Main {
    public static void main(String[] args) {
        RecursoServidor jardin = new RecursoServidor();
        for (int i = 0; i < 4; i++) {
            EntraJardin entraJardin = new EntraJardin("Ordenador numero:"+( i+1), jardin);
            entraJardin.start();
        }

    }
}