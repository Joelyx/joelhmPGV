package com.example.productorconsumidor;

import java.util.Stack;

public class Buffer {
    private Stack<Character> buffer = new Stack<>();
    private int maxSize = 6;

    public synchronized boolean addToBuffer(char input) {
        try {
            while (buffer.size() >= maxSize) {
                notify();
                wait(); // Esperar si el búfer está lleno
            }
            buffer.push(input);
            System.out.println("Buffer" + buffer.toString());
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public synchronized boolean removeFromBuffer() {
        try {
            while (buffer.isEmpty()) {
                wait(); // Esperar si el búfer está vacío
            }
            buffer.pop();
            Thread.sleep(3000);
            notify(); // Notificar a los hilos esperando
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
