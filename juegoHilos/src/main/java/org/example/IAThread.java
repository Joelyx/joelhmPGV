package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class IAThread implements Runnable{
    private Tablero tablero;

    private boolean gameOver=false;
    private int puntuacion=0;
    private Semaphore turno;

    public IAThread(Tablero tablero, Semaphore turno){
        this.tablero=tablero;
        this.turno=turno;
    }

    @Override
    public void run() {
        while (!gameOver) {
            try {

                turno.acquire();
                tablero.printBoard();
                Thread.sleep(500);
                Random random = new Random();
                int row = random.nextInt(tablero.getBOARD_SIZE());
                char rowLetter = (char) (row + 'A');
                int col = random.nextInt(tablero.getBOARD_SIZE())+1;
                System.out.println("La IA dispara a la casilla " + rowLetter + col);
                if(tablero.checkGuess(rowLetter, col)){
                    puntuacion++;
                }
                turno.release();
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Puntuación final de la IA: " + puntuacion);

    }
}
