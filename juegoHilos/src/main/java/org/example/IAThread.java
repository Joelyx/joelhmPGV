package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class IAThread implements Runnable{
    private Tablero tablero;

    private boolean gameOver=false;
    private int puntuacion=0;
    private Semaphore turno;

    /**
     * Constructor de la clase IAThread
     * @param tablero en el que se juega
     * @param turno semaforo que controla el turno
     */
    public IAThread(Tablero tablero, Semaphore turno){
        this.tablero=tablero;
        this.turno=turno;
    }

    /**
     * Metodo que ejecuta la IA
     * Se ejecuta mientras el juego no haya terminado
     * Trata de adquirir el semaforo (turno)
     * Se duerme 500ms para que el usuario pueda ver el tablero
     * Se genera un numero aleatorio para la fila y la columna
     * Se comprueba si el disparo ha sido acertado
     */
    @Override
    public void run() {
        while (!gameOver) {
            try {
                gameOver= tablero.getGameOver();
                turno.acquire(); // Adquirir semaforo
                tablero.printBoard();
                Thread.sleep(500);
                Random random = new Random();
                int row = random.nextInt(tablero.getBOARD_SIZE());
                char rowLetter = (char) (row + 'A');
                int col = random.nextInt(tablero.getBOARD_SIZE())+1;
                if(!gameOver) {
                    System.out.println("La IA dispara a la casilla " + rowLetter + col);
                }
                if(tablero.checkGuess(rowLetter, col)){
                    puntuacion++; //Control de puntuación de la IA
                }
                turno.release(); // Soltar semaforo
                Thread.sleep(500);
                gameOver= tablero.getGameOver();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Puntuación final de la IA: " + puntuacion);

    }
}
