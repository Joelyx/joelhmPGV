package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    private static final int BOARD_SIZE = 5;
    private static boolean[][] marked;
    private static int targetRow, targetCol;
    private static boolean gameOver = false;

    public static void main(String[] args) {

        Semaphore turno = new Semaphore(1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño del tablero (entre 5 y 10): ");
        int size = sc.nextInt();sc.nextLine();
        System.out.println("Introduce el número de barcos (entre 1 y 6): ");
        int barcos = sc.nextInt();sc.nextLine();
        //sc.close();

        Tablero tablero = new Tablero(size, barcos);

        tablero.initializeBoard();

        UserThread userThread = new UserThread(tablero, turno);
        IAThread iaThread = new IAThread(tablero, turno);

        userThread.run();
        iaThread.run();

    }
}