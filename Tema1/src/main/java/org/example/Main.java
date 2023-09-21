package org.example;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        creador("ping");
        //creador("code");
    }
    public static void creador( String a){
        ProcessBuilder processBuilder = new ProcessBuilder(a, "www.google.es");
        try{
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process porcess = processBuilder.start();
            porcess.waitFor();
            System.out.println("Fin de proceso");
        } catch (IOException ex){
            System.out.println("Error");
        } catch (InterruptedException e) {
            System.out.println("cuca");
        }
    }




    /*public static void main(String[] args) {
        creador("ifconfig");
        //creador("code");
    }
    public static void creador( String a){
        ProcessBuilder processBuilder = new ProcessBuilder(a);
        try{
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process porcess = processBuilder.start();
            porcess.waitFor();
            System.out.println("Fin de proceso");
        } catch (IOException ex){
            System.out.println("Error");
        } catch (InterruptedException e) {
            System.out.println("cuca");
        }
    }*/



    /*public static void main(String[] args) {
        creador("ip config");
        //creador("code");
     }
     public static void creador( String a){
         ProcessBuilder processBuilder = new ProcessBuilder(a, "/home/dam2/Escritorio/aaa.txt");
         try{
             processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
             Process porcess = processBuilder.start();
             porcess.waitFor();
             System.out.println("Fin de proceso");
         } catch (IOException ex){
             System.out.println("Error");
         } catch (InterruptedException e) {
             System.out.println("cuca");
         }
     }*/
}