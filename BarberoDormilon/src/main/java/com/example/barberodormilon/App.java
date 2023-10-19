package com.example.barberodormilon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Barberia barberia = new Barberia(3); // Definimos 3 sillas en la sala de espera

        Barbero barbero = new Barbero(barberia);
        barbero.start();

        Cliente cliente1 = new Cliente(barberia, "Cliente 1");
        Cliente cliente2 = new Cliente(barberia, "Cliente 2");
        Cliente cliente3 = new Cliente(barberia, "Cliente 3");
        Cliente cliente4 = new Cliente(barberia, "Cliente 4");

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();

    }
}
