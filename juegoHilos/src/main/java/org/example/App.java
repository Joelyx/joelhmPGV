package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {

    public static void main(String[] args) {
        Semaphore turno = new Semaphore(1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño del tablero (entre 5 y 10): ");
        int size = sc.nextInt();sc.nextLine();
        System.out.println("Introduce el número de barcos (entre 1 y 6): ");
        int barcos = sc.nextInt();sc.nextLine();
        //sc.close();


        Tablero tablero = new Tablero(size, barcos); //Aqui reside la modificacion del tamaño del tablero y la cantidad de barcos

        UserThread userThread = new UserThread(tablero, turno);
        IAThread iaThread = new IAThread(tablero, turno);

        Thread userThreadT = new Thread(userThread);
        Thread iaThreadT = new Thread(iaThread);

        userThreadT.start();
        iaThreadT.start();
    }
}