package org.example;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class UserThread implements Runnable{

    public Tablero tablero;
    private boolean gameOver=false;
    private int puntuacion=0;
    private Semaphore turno;

    public UserThread(Tablero tablero, Semaphore turno){
        this.tablero=tablero;
        this.turno=turno;
    }

    /**
     * Metodo que ejecuta el usuario
     * Se ejecuta mientras el juego no haya terminado
     * Trata de adquirir el semaforo (turno)
     * Se pide al usuario que introduzca una letra y un numero
     * Se comprueba si el disparo ha sido acertado
     * Se libera el semaforo (turno)
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            try {
                turno.acquire(); // Adquirir semaforo

                tablero.printBoard();

                System.out.print("Introduce una letra y un número (ejemplo: A2): ");
                String input = scanner.nextLine();
                if (input.length() != 2) {
                    System.out.println("Entrada inválida. Debe ser una letra y un número.");
                    continue;
                }
                char letter = input.charAt(0);
                System.out.println("char at 0" + letter);
                int number = Character.getNumericValue(input.charAt(1));
                if (letter >= 'A' && letter < 'A' + tablero.getBOARD_SIZE() && number >= 1 && number <= tablero.getBOARD_SIZE()) {
                    if (tablero.checkGuess(letter, number)) {
                        puntuacion++; //Control de puntuación del usuario
                    }
                } else {
                    System.out.println("Entrada inválida. Letra entre A y E, número entre 1 y 5.");
                }
                turno.release(); // Soltar semaforo
                Thread.sleep(20);
                gameOver= tablero.getGameOver();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Tu puntuación final: " + puntuacion);
            }
        }

    }
}
