package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private int BOARD_SIZE;
    private char[][] board;
    private int numBarcos;
    private ArrayList<Barco> barcos;
    private boolean gameOver=false;

    public Tablero(int size, int numBarcos){
        this.BOARD_SIZE=size;
        this.numBarcos = numBarcos;
        this.barcos = new ArrayList<>();
        if(numBarcos >6){
            this.numBarcos =5;
        } else if (numBarcos <1){
            this.numBarcos =1;
        }
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }



    public void initializeBoard() {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                board[i][j] = '~'; // Agua
            }
        }
        for (int i = 0; i < numBarcos; i++) {
            int targetRow = (new Random()).nextInt(this.BOARD_SIZE);
            int targetCol = (new Random()).nextInt(this.BOARD_SIZE);
            if (!barcos.isEmpty()) {
                for (Barco barco : barcos) {
                    if (barco.getX() == targetRow && barco.getY() == targetCol) {
                        i--;
                        continue;
                    }
                }
            } else {
                barcos.add(new Barco(targetRow, targetCol));
                i--;
            }
        }
    }

    public boolean checkGuess(char rowLetter, int col) {
        int row = (int)(rowLetter - 'A');
        col = col - 1; // Ajustar porque los índices del array empiezan en 0

        if (board[row][col] == 'D' || board[row][col] == 'X') {
            System.out.println("Ya habías disparado ahí.");
            return false;
        }

        for (Barco barco : barcos) {
            if (barco.getX() == row && barco.getY() == col) {
                System.out.println("¡Hundido!");
                numBarcos--;
                barco.setHundido();
                board[row][col] = 'X'; // Disparo acertado
                if (numBarcos== 0) {
                    System.out.println("¡Has hundido todos los barcos!");
                    gameOver = true;

                }
                return true;
            }
        }

        System.out.println("¡Agua!");
        board[row][col] = 'D'; // Disparo fallido
        return false;
    }


    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public void setBOARD_SIZE(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getNumBarcos() {
        return numBarcos;
    }

    public void setNumBarcos(int numBarcos) {
        this.numBarcos = numBarcos;
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }
}
